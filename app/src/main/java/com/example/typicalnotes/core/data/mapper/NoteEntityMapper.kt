package com.example.typicalnotes.core.data.mapper

import com.example.typicalnotes.core.data.source.local.model.NoteEntity
import com.example.typicalnotes.core.domain.model.Note

fun NoteEntity.toNote() = Note(id, title, description)
fun Note.toNoteEntity() = NoteEntity(id, title, description)
