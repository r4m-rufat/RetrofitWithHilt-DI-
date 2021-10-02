package com.codingwithrufat.filmswithhilt.utils

import com.codingwithrufat.filmswithhilt.models.ResponseItem

sealed class ApiState{
    class SUCCESS(val data: List<ResponseItem?>?): ApiState()
    class FAILURE(val message: Throwable): ApiState()
    object EMPTY: ApiState()
}
