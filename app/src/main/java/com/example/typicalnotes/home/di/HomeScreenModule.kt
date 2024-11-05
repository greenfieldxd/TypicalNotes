package com.example.typicalnotes.home.di

import com.example.typicalnotes.home.domain.usecase.DeleteNoteUseCase
import com.example.typicalnotes.home.domain.usecase.GetAllNotesUseCase
import com.example.typicalnotes.home.domain.usecase.impl.DeleteNoteUseCaseImpl
import com.example.typicalnotes.home.domain.usecase.impl.GetAllNotesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeScreenModule {

    @Binds
    abstract fun bindDeleteNoteUseCase(
        deleteNoteUseCaseImpl: DeleteNoteUseCaseImpl
    ) : DeleteNoteUseCase

    @Binds
    abstract fun bindGetAllNotesUseCase(
        getAllNotesUseCaseImpl: GetAllNotesUseCaseImpl
    ) : GetAllNotesUseCase
}