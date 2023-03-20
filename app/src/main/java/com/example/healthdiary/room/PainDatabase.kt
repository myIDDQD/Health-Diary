package com.example.healthdiary.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Pain::class), version = 1, exportSchema = false)
abstract class PainDatabase : RoomDatabase() {

    abstract fun getPainsDao(): PainsDao

    companion object {
        // Singleton prevents multiple
        // instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: PainDatabase? = null

        fun getDatabase(context: Context): PainDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PainDatabase::class.java,
                    "Pain_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
