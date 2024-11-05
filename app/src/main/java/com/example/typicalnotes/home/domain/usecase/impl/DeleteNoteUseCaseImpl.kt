package com.example.typicalnotes.home.domain.usecase.impl

import com.example.typicalnotes.core.data.repository.LocalDataSourceRepository
import com.example.typicalnotes.core.domain.model.Note
import com.example.typicalnotes.home.domain.usecase.DeleteNoteUseCase
import javax.inject.Inject

class DeleteNoteUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): DeleteNoteUseCase {

    override suspend operator fun invoke(note: Note) {
        localDataSourceRepository.deleteNote(note)
    }
}