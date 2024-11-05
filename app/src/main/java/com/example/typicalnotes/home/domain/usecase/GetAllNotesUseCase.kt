package com.example.typicalnotes.home.domain.usecase

import com.example.typicalnotes.core.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface GetAllNotesUseCase {
    operator fun invoke(): Flow<List<Note>>
}