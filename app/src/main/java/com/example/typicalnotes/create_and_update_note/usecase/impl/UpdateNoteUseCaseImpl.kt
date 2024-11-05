package com.example.typicalnotes.create_and_update_note.usecase.impl

import com.example.typicalnotes.core.data.repository.LocalDataSourceRepository
import com.example.typicalnotes.core.domain.model.Note
import com.example.typicalnotes.create_and_update_note.usecase.UpdateNoteUseCase
import javax.inject.Inject

class UpdateNoteUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): UpdateNoteUseCase {
    override suspend operator fun invoke(note: Note) = localDataSourceRepository.updateNote(note)
}