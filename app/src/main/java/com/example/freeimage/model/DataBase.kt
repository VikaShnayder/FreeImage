package com.example.freeimage.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ImageEntity::class], version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun getDao(): ImageDao
//    companion object{
//        fun getDb(context: Context): DataBase {
//            return Room.databaseBuilder(
//                context.applicationContext,
//                DataBase::class.java,
//                "images.db"
//            ).build()
//        }
//    }

    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null
        fun getDb(context: Context): DataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "images_database.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}