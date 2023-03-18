package com.example.healthdiary.Database

import HealthNote
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        HealthNote::class,
        BodyParts::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getStatisticDao(): BaseDao

}