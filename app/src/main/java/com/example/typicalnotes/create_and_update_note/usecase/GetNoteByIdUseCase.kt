package com.example.typicalnotes.create_and_update_note.usecase

import com.example.typicalnotes.core.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface GetNoteByIdUseCase {
    operator fun invoke(id: Int): Flow<Note>
}