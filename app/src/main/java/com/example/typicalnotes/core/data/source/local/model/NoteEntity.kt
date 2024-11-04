package com.example.typicalnotes.core.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = NoteEntity.Companion.NOTE_TABLE_NAME)
data class NoteEntity(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val description: String
){
    companion object{
        const val NOTE_TABLE_NAME: String = "NOTE_TABLE_NAME"
    }
}