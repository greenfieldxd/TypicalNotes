package com.example.typicalnotes.core.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM ${com.example.typicalnotes.core.data.source.local.model.NoteEntity.Companion.NOTE_TABLE_NAME}")
    fun getAllNotes() : Flow<List<com.example.typicalnotes.core.data.source.local.model.NoteEntity>>

    @Query("SELECT * FROM ${com.example.typicalnotes.core.data.source.local.model.NoteEntity.Companion.NOTE_TABLE_NAME} WHERE id=:id")
    fun getNoteById(id: Int) : Flow<com.example.typicalnotes.core.data.source.local.model.NoteEntity>

    @Insert
    fun insertNote(note: com.example.typicalnotes.core.data.source.local.model.NoteEntity)

    @Update
    fun updateNote(note: com.example.typicalnotes.core.data.source.local.model.NoteEntity)

    @Delete
    fun delete(note: com.example.typicalnotes.core.data.source.local.model.NoteEntity)
}