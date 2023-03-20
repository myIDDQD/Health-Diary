package com.example.healthdiary.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.healthdiary.Database.BodyParts
import java.time.LocalDateTime

@Entity(tableName = "notesTable")
class Pain (
    @PrimaryKey(autoGenerate = true) var id : Int = 0,
    @ColumnInfo(name = "date") val date : LocalDateTime,
    @ColumnInfo(name = "parts") val bodyParts: BodyParts,
    @ColumnInfo(name = "description") val painDescription : String)
