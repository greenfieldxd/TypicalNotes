package com.example.typicalnotes.create_and_update_note.usecase

import com.example.typicalnotes.core.domain.model.Note

interface UpdateNoteUseCase {
    suspend operator fun invoke(note: Note)
}