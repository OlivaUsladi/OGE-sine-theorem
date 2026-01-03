package com.example.oge_sine_theorem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.oge_sine_theorem.ui.theme.CanvasPage
import com.example.oge_sine_theorem.ui.theme.NamePage
import com.example.oge_sine_theorem.ui.theme.OGE_sine_theoremTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AppNavigation(navController = navController)
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "namePage"
    ) {
        composable("namePage") {
            NamePage(navController = navController)
        }
        composable("canvasPage"+"/{a}/{b}/{c}") {stackEntry ->
            val a = stackEntry.arguments?.getString("a") ?: "A"
            val b = stackEntry.arguments?.getString("b") ?: "B"
            val c = stackEntry.arguments?.getString("c") ?: "C"
            CanvasPage(navController = navController, A = a, B = b, C = c)
        }
    }
}


