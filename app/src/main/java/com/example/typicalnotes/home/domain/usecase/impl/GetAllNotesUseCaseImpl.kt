package com.example.typicalnotes.home.domain.usecase.impl

import com.example.typicalnotes.core.data.repository.LocalDataSourceRepository
import com.example.typicalnotes.home.domain.usecase.GetAllNotesUseCase
import javax.inject.Inject

class GetAllNotesUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): GetAllNotesUseCase {

    override operator fun invoke() = localDataSourceRepository.getAllNotesFlow()
}