package com.example.typicalnotes.create_and_update_note.usecase.impl

import com.example.typicalnotes.core.data.repository.LocalDataSourceRepository
import com.example.typicalnotes.core.domain.model.Note
import com.example.typicalnotes.create_and_update_note.usecase.AddNoteUseCase
import javax.inject.Inject

class AddNoteUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): AddNoteUseCase {
    override suspend operator fun invoke(note: Note) { localDataSourceRepository.addNote(note)
    }
}