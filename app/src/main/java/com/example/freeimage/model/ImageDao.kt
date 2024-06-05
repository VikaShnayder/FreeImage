package com.example.freeimage.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {
    @Insert
    suspend fun insert(image: ImageEntity)

    @Query("SELECT * FROM images")
    fun getAll(): Flow<List<ImageEntity>>

    @Delete
    suspend fun delete(image: ImageEntity)
}