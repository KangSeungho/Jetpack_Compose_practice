package app.sosocom.jetpack_compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
            LazyColumn(modifier = Modifier
                .background(color = Color.Green)
                .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)    // 컴포넌트간 간격
            ) {
                item {
                    Text("Header")
                }
                items(50) { index ->
                    Text("글씨 $index")
                }
                item {
                    Text("Footer")
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