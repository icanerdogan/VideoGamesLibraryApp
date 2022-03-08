package com.icanerdogan.videogameslibrary.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.icanerdogan.videogameslibrary.model.DetailGame

@Database(entities = arrayOf(DetailGame::class), version = 1)
abstract class FavoriteGameDatabase : RoomDatabase() {
    abstract fun favoriteGameDao() : FavoriteGameDAO

    // Singleton

    companion object{
        @Volatile private var instance : FavoriteGameDatabase? = null

        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }

        private fun makeDatabase(context : Context) = Room.databaseBuilder(
            context.applicationContext, FavoriteGameDatabase::class.java,  "favoritegamedatabase"
        ).build()
    }


}