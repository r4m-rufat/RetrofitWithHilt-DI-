package com.codingwithrufat.filmswithhilt.models

data class Response(
	val response: List<ResponseItem?>? = null
)

data class ResponseItem(
	val id: Int? = null,
	val title: String? = null,
	val body: String? = null,
	val userId: Int? = null
)

