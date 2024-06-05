package com.example.freeimage.retrofit

import com.example.freeimage.model.ImageItemResponce
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientApi {
    /*@GET("/")
    suspend fun fetchResponse(@Query("key") apikey: String): ImageItemResponce

    @GET("/")
    suspend fun getImageByTitle(@Query("key") apikey: String, @Query("q") q: String): ImageItemResponce

    @GET("/")
    suspend fun getImageByType(@Query("key") apikey: String, @Query("image_type") image_type: String): ImageItemResponce

    @GET("/")
    suspend fun getImageByOrientation(@Query("key") apikey: String, @Query("orientation") orientation: String): ImageItemResponce

    @GET("/")
    suspend fun getImageByCategory(@Query("key") apikey: String, @Query("category") category: String): ImageItemResponce
*/
    @GET("/api/")
    suspend fun getImageByColors(@Query("key") apikey: String, @Query("colors") color: String): ImageItemResponce



}