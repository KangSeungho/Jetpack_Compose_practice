package app.sosocom.jetpack_compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "first"
            ) {
                composable("first") {
                    FirstScreen(navController)
                }

                composable("second") {
                    SecondScreen(navController)
                }

                composable("third/{value}") {
                    ThirdScreen(navController, it.arguments?.getString("value") ?: "")
                }
            }
        }
    }
}

@Composable
fun FirstScreen(navController: NavController) {
    val (value, setValue) = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "첫 화면")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate("second")
        }) {
            Text("두 번째 화면 이동!")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = value, onValueChange = setValue)
        Button(onClick = {
            if(value.isEmpty()) return@Button

            navController.navigate("third/$value")
        }) {
            Text("세 번째 화면 이동!")
        }
    }
}

@Composable
fun SecondScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "두 번째 화면")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigateUp()
        }) {
            Text("뒤로가기")
        }
    }
}

@Composable
fun ThirdScreen(navController: NavController, text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "세 번째 화면")
        Text(text = text)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigateUp()
        }) {
            Text("뒤로가기")
        }
    }
}