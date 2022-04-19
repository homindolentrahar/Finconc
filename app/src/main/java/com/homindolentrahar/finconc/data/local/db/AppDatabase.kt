package com.homindolentrahar.finconc.data.local.db

import android.content.Context
import android.database.Cursor
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.homindolentrahar.finconc.data.local.db.dao.FlowerDao
import com.homindolentrahar.finconc.data.local.db.model.FlowerEntity

@Database(entities = [FlowerEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun flowerDao(): FlowerDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "database.db"
        ).build().also {
            INSTANCE = it
        }
    }
}