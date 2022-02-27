package app.sosocom.jetpack_compose_practice.feature_note.domain.use_cases

import app.sosocom.jetpack_compose_practice.feature_note.domain.model.Note
import app.sosocom.jetpack_compose_practice.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) = repository.deleteNote(note)
}