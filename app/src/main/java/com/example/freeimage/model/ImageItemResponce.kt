package com.example.freeimage.model

import com.example.freeimage.retrofit.Image
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ImageItemResponce(
    @Json(name = "hits")
    val items: List<Image>?,
)