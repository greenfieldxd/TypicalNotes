package com.example.typicalnotes.create_and_update_note.di

import com.example.typicalnotes.create_and_update_note.usecase.AddNoteUseCase
import com.example.typicalnotes.create_and_update_note.usecase.GetNoteByIdUseCase
import com.example.typicalnotes.create_and_update_note.usecase.UpdateNoteUseCase
import com.example.typicalnotes.create_and_update_note.usecase.impl.AddNoteUseCaseImpl
import com.example.typicalnotes.create_and_update_note.usecase.impl.GetNoteByIdUseCaseImpl
import com.example.typicalnotes.create_and_update_note.usecase.impl.UpdateNoteUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CreateUpdateNoteDomainModule {

    @Binds
    abstract fun bindAddNoteUseCase(
        addNoteUseCaseImpl: AddNoteUseCaseImpl
    ): AddNoteUseCase

    @Binds
    abstract fun bindGetNoteByIdUseCase(
        getNoteByIdUseCaseImpl: GetNoteByIdUseCaseImpl
    ): GetNoteByIdUseCase

    @Binds
    abstract fun bindUpdateNoteUseCase(
        updateNoteUseCaseImpl: UpdateNoteUseCaseImpl
    ): UpdateNoteUseCase
}
