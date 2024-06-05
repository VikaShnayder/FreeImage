package com.example.freeimage.retrofit

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Image(
    @ColumnInfo(name = "previewURL")
    val previewURL: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "tags")
    val tags: String,
    @ColumnInfo(name = "user")
    val user: String,
    @ColumnInfo(name = "userImageURL")
    val userImageURL: String,
)