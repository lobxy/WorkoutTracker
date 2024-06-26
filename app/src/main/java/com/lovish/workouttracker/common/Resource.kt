package com.lovish.workouttracker.common

sealed class Resource<T>(val data: T? = null, val message: String? = null, val errorCode: Int? = -1) {
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(errorCode: Int? = -1, message: String? = null, data: T? = null) : Resource<T>(data, message, errorCode)
}