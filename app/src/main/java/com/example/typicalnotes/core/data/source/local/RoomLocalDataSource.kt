package com.example.typicalnotes.core.data.source.local

import com.example.typicalnotes.core.data.mapper.NoteEntityMapper.toNote
import com.example.typicalnotes.core.data.mapper.NoteEntityMapper.toNoteEntity
import com.example.typicalnotes.core.domain.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.collections.map

class RoomLocalDataSource @Inject constructor(
    private val noteDao: com.example.typicalnotes.core.data.source.local.dao.NoteDao
) : LocalDataSource {

    override fun getAllNotesFlow(): Flow<List<Note>> {
        return noteDao.getAllNotes().map { noteEntityList ->
            noteEntityList.map { noteEntity -> noteEntity.toNote() }
        }
    }

    override fun gelNoteByIdFlow(id: Int): Flow<Note> {
        return noteDao.getNoteById(id).map { noteEntity ->
            noteEntity.toNote()
        }
    }

    override suspend fun addNote(note: Note) {
        noteDao.insertNote(note.toNoteEntity())
    }

    override suspend fun updateNote(note: Note) {
        noteDao.updateNote(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.delete(note.toNoteEntity())
    }
}