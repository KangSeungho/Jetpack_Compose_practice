package app.sosocom.jetpack_compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.sosocom.jetpack_compose_practice.ui.theme.Jetpack_compose_practiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SetView() }
    }
}

@Composable
fun SetView() {
    Jetpack_compose_practiceTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Box(modifier = Modifier
                .background(color = Color.Green)
                .fillMaxWidth()
                .height(200.dp)
            ) {
                Text("Hello")
                Box(
                    modifier = Modifier.fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Text("1234455~~~~~~!!!")
                }
            }
        }
    }
}

@Preview
@Composable
fun SetViewPreview() {
    SetView()
}