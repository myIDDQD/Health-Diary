package com.example.healthdiary.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "body_parts")
data class BodyParts(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "part_body") val bodyPart: String
)