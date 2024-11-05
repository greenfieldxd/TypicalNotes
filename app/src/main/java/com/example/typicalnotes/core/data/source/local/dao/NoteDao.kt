package com.example.typicalnotes.core.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.typicalnotes.core.data.source.local.model.NoteEntity
import com.example.typicalnotes.core.data.source.local.model.NoteEntity.Companion.NOTE_TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM $NOTE_TABLE_NAME")
    fun getAllNotes() : Flow<List<NoteEntity>>

    @Query("SELECT * FROM $NOTE_TABLE_NAME WHERE id=:id")
    fun getNoteById(id: Int) : Flow<NoteEntity>

    @Insert
    fun insertNote(note: NoteEntity)

    @Update
    fun updateNote(note: NoteEntity)

    @Delete
    fun delete(note: NoteEntity)
}