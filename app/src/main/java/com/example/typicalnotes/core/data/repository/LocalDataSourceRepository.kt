package com.example.typicalnotes.core.data.repository

import com.example.typicalnotes.core.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface LocalDataSourceRepository {
    fun getAllNotesFlow(): Flow<List<Note>>

    fun getNoteByIdFlow(id: Int): Flow<Note>

    suspend fun addNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)
}