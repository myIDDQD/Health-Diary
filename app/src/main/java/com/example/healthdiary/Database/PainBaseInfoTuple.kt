package com.example.healthdiary.Database

import androidx.room.ColumnInfo

class PainBaseInfoTuple(
    val id: Int,
    @ColumnInfo(name = "result_name") val result: String,
    @ColumnInfo(name = "difficulty_name") val difficult: String,
    val mistakes: Long,
    val points: Long)