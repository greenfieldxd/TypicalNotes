package com.example.typicalnotes.home.domain.usecase

import com.example.typicalnotes.core.domain.model.Note

interface DeleteNoteUseCase {
    suspend operator fun invoke(note: Note)
}