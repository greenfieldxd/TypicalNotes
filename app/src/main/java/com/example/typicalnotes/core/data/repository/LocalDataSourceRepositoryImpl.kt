package com.example.typicalnotes.core.data.repository

import com.example.typicalnotes.core.data.source.local.LocalDataSource
import com.example.typicalnotes.core.domain.model.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : LocalDataSourceRepository{
    override fun getAllNotesFlow(): Flow<List<Note>> = localDataSource.getAllNotesFlow()

    override fun getNoteByIdFlow(id: Int): Flow<Note> = localDataSource.gelNoteByIdFlow(id)

    override suspend fun addNote(note: Note) = localDataSource.addNote(note)

    override suspend fun updateNote(note: Note) = localDataSource.updateNote(note)

    override suspend fun deleteNote(note: Note) = localDataSource.deleteNote(note)
}