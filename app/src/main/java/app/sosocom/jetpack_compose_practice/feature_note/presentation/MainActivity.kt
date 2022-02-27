package app.sosocom.jetpack_compose_practice.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import app.sosocom.jetpack_compose_practice.ui.theme.Jetpack_compose_practiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_compose_practiceTheme {

            }
        }
    }
}