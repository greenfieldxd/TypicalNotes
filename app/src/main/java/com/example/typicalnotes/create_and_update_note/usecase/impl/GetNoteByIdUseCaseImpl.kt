package com.example.typicalnotes.create_and_update_note.usecase.impl

import com.example.typicalnotes.core.data.repository.LocalDataSourceRepository
import com.example.typicalnotes.create_and_update_note.usecase.GetNoteByIdUseCase
import javax.inject.Inject

class GetNoteByIdUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): GetNoteByIdUseCase {
    override operator fun invoke(id: Int) = localDataSourceRepository.getNoteByIdFlow(id)
}