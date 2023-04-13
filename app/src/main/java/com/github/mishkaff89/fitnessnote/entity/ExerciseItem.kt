package com.github.mishkaff89.fitnessnote.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "exercise_item")
data class ExerciseItem(

    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val type: Int,
    @ColumnInfo
    val listId: Int,
    @ColumnInfo
    val time: String,


    //value - weight or time
    @ColumnInfo
    val value1_1: String,
    @ColumnInfo
    val value1_2: String,
    @ColumnInfo
    val value1_3: String,
    @ColumnInfo
    val value1_4: String,
    @ColumnInfo
    val value1_5: String,
    @ColumnInfo
    val value1_6: String,
    @ColumnInfo
    val value1_7: String,
    @ColumnInfo
    val value1_8: String,
    @ColumnInfo
    val value1_9: String,
    @ColumnInfo
    val value1_10: String,

    //value2 - quantity or distance
    @ColumnInfo
    val value2_1: String,
    @ColumnInfo
    val value2_2: String,
    @ColumnInfo
    val value2_3: String,
    @ColumnInfo
    val value2_4: String,
    @ColumnInfo
    val value2_5: String,
    @ColumnInfo
    val value2_6: String,
    @ColumnInfo
    val value2_7: String,
    @ColumnInfo
    val value2_8: String,
    @ColumnInfo
    val value2_9: String,
    @ColumnInfo
    val value2_10: String,




)
