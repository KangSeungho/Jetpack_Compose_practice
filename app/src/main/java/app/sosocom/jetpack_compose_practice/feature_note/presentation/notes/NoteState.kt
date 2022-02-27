package app.sosocom.jetpack_compose_practice.feature_note.presentation.notes

import app.sosocom.jetpack_compose_practice.feature_note.domain.model.Note
import app.sosocom.jetpack_compose_practice.feature_note.domain.util.NoteOrder
import app.sosocom.jetpack_compose_practice.feature_note.domain.util.OrderType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
