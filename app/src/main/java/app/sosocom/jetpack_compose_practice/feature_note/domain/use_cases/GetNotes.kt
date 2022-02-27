package app.sosocom.jetpack_compose_practice.feature_note.domain.use_cases

import app.sosocom.jetpack_compose_practice.feature_note.domain.repository.NoteRepository
import app.sosocom.jetpack_compose_practice.feature_note.domain.util.NoteOrder
import app.sosocom.jetpack_compose_practice.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.map

class GetNotes(
    private val repository: NoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    ) = repository.getNotes().map { notes ->
        when(noteOrder.orderType) {
            is OrderType.Ascending -> {
                when(noteOrder) {
                    is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                    is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                    is NoteOrder.Color -> notes.sortedBy { it.color }
                }
            }

            is OrderType.Descending -> {
                when(noteOrder) {
                    is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                    is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                    is NoteOrder.Color -> notes.sortedByDescending { it.color }
                }
            }
        }
    }
}