package com.github.mishkaff89.fitnessnote.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "training_items")
data class TrainingItem (

    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val time: String,

): Serializable