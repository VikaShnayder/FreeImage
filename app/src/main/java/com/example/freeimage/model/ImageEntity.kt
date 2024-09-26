package com.example.freeimage.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class ImageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "pageURL")
    val pageURL: String,
    @ColumnInfo(name = "previewURL")
    val previewURL: String,
    @ColumnInfo(name = "userImageURL")
    val userImageURL: String,
    @ColumnInfo(name = "user")
    val user: String,

    @ColumnInfo(name = "likes")
    val likes: String,
    @ColumnInfo(name = "downloads")
    val downloads: String,
    @ColumnInfo(name = "comments")
    val comments: String,
    @ColumnInfo(name = "views")
    val views: String,

    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "tags")
    val tags: String,

)
