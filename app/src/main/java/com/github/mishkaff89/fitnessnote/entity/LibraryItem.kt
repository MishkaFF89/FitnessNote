package com.github.mishkaff89.fitnessnote.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "library_item")
data class LibraryItem (
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    @ColumnInfo
    val name: String

)