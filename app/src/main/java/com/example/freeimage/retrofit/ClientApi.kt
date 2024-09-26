package com.example.freeimage.retrofit

import androidx.room.ColumnInfo
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
    suspend fun getImageByColor(@Query("key") apikey: String, @Query("colors") color: String, @Query("per_page") perpage: Int, @Query("page") page: Int,): ImageItemResponce
    @GET("/api/")
    suspend fun getImageByParametrs(
        @Query("key") apikey: String,
        @Query("per_page") perpage: Int = 30,
        @Query("page") page: Int,
        @Query("colors") color: String,
        @Query("q") q: String,
        @Query("lang") lang: String,
        @Query("image_type") type: String,
        @Query("orientation") orientation: String,
        @Query("category") category: String,
        @Query("order") order: String,
    ): ImageItemResponce






//нужно реализовать перелистывание страниц с изображениями(чтобы увидеть остальнфые)
//использовать per_page= от 3 до 200 чтьобы указать количество изображений на странице
//использовать page= от 1 до ... чтьобы переходить к следующей страницу с изображениями
}