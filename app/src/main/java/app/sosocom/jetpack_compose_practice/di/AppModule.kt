package app.sosocom.jetpack_compose_practice.di

import android.app.Application
import androidx.room.Room
import app.sosocom.jetpack_compose_practice.feature_note.data.data_source.NoteDatabase
import app.sosocom.jetpack_compose_practice.feature_note.data.repository.NoteRepositoryImpl
import app.sosocom.jetpack_compose_practice.feature_note.domain.repository.NoteRepository
import app.sosocom.jetpack_compose_practice.feature_note.domain.use_cases.AddNote
import app.sosocom.jetpack_compose_practice.feature_note.domain.use_cases.DeleteNote
import app.sosocom.jetpack_compose_practice.feature_note.domain.use_cases.GetNotes
import app.sosocom.jetpack_compose_practice.feature_note.domain.use_cases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application) = Room.databaseBuilder(
        app,
        NoteDatabase::class.java,
        NoteDatabase.DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase) = NoteRepositoryImpl(db.noteDao)

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository) = NoteUseCases(
        getNotes = GetNotes(repository),
        deleteNote = DeleteNote(repository),
        addNote = AddNote(repository)
    )
}