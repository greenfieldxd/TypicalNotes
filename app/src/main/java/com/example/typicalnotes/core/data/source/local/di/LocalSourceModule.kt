package com.example.typicalnotes.core.data.source.local.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.example.typicalnotes.core.data.repository.LocalDataSourceRepository
import com.example.typicalnotes.core.data.repository.LocalDataSourceRepositoryImpl
import com.example.typicalnotes.core.data.source.local.LocalDataSource
import com.example.typicalnotes.core.data.source.local.RoomLocalDataSource
import com.example.typicalnotes.core.data.source.local.db.NotesRoomDatabase
import com.example.typicalnotes.core.data.source.local.db.NotesRoomDatabase.Companion.DATABASE_NAME
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalSourceModuleProvider {

    @Provides
    fun provideNoteDao(database: NotesRoomDatabase) = database.noteDao()

    @Provides
    @Singleton
    fun providesLocalDatabase(
        @ApplicationContext context: Context
    ) = databaseBuilder(
        context,
        NotesRoomDatabase::class.java,
        DATABASE_NAME
        ).build()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModuleBinder {

    @Binds
    abstract fun bindRoomLocalDataSource(
        roomLocalDataSource: RoomLocalDataSource
    ) : LocalDataSource

    @Binds
    abstract fun bindDefaultTypicalNotesRepository(
        defaultTypicalNoteRepository: LocalDataSourceRepositoryImpl
    ) : LocalDataSourceRepository
}