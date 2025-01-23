package com.mabrouk.mohamed.cardscanner.presentation.screens.scan

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.mabrouk.mohamed.cardscanner.presentation.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScanViewModel @Inject constructor() : ViewModel() {
    private val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    private val _detectorResult = MutableStateFlow<Resource<String>>(Resource.Empty)
    val detectorResult: StateFlow<Resource<String>> = _detectorResult

    fun processImage(bitmap: Bitmap) {
        viewModelScope.launch {
            _detectorResult.value = Resource.Loading
            val image = InputImage.fromBitmap(bitmap, 0)

            recognizer.process(image)
                .addOnSuccessListener { visionText ->
                    val text = getMaxString(visionText)
                    if (text == null) {
                        _detectorResult.value = Resource.Error("")
                    } else {
                        _detectorResult.value = Resource.Success(text)
                    }
                }
                .addOnFailureListener { _ ->
                    _detectorResult.value = Resource.Error("")
                }
        }
    }


    private fun getMaxString(texts: Text): String? {
        val blocks: List<Text.TextBlock> = texts.textBlocks
        var maxLength = 0
        var maxLengthString: String? = null

        for (i in blocks.indices) {
            for (j in blocks[i].lines.indices) {
                if (blocks[i].lines[j].text.length > maxLength) {
                    val newString = blocks[i].lines[j].text.replace(" ", "")
                    if (newString.all { it.isDigit() }) {
                        maxLength = blocks[i].lines[j].text.length
                        maxLengthString = newString
                    }
                }
            }
        }
        return maxLengthString
    }
}