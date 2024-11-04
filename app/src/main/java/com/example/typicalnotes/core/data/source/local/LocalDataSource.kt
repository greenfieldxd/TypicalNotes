package com.example.typicalnotes.core.data.source.local

import com.example.typicalnotes.core.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getAllNotesFlow(): Flow<List<Note>>

    fun gelNoteByIdFlow(id: Int): Flow<Note>

    suspend fun addNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)
}