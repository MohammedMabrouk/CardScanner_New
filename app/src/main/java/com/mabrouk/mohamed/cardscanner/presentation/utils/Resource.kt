package com.mabrouk.mohamed.cardscanner.presentation.utils

sealed class Resource<out T : Any> {
    data object Empty: Resource<Nothing>()
    data object Loading : Resource<Nothing>()
    data class Error(val exception: String) : Resource<Nothing>()
    data class Success<out T : Any>(val data: T) : Resource<T>()
}