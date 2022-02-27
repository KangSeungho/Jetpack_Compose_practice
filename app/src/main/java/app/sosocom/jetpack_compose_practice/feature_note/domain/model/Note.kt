package app.sosocom.jetpack_compose_practice.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.sosocom.jetpack_compose_practice.ui.theme.*

@Entity
data class Note(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}