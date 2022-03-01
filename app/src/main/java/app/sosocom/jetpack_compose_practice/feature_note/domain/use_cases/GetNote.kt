package app.sosocom.jetpack_compose_practice.feature_note.domain.use_cases

import app.sosocom.jetpack_compose_practice.feature_note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int) = repository.getNoteById(id)
}