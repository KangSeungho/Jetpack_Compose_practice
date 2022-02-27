package app.sosocom.jetpack_compose_practice.feature_note.domain.util

sealed class NoteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): NoteOrder(orderType)
    class Date(orderType: OrderType): NoteOrder(orderType)
    class Color(orderType: OrderType): NoteOrder(orderType)

    fun copy(orderType: OrderType) = when(this) {
        is Title -> Title(orderType)
        is Date -> Date(orderType)
        is Color -> Color(orderType)
    }
}