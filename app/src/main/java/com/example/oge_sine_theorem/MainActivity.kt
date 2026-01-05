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
import com.example.oge_sine_theorem.ui.theme.ResultPage

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

//Добавить возможность введения синуса (косинуса)?
//Высчитывание радиуса описанной окружности
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
        composable("resultPage/{a}/{b}/{c}/{ab}/{bc}/{ac}/{angleA}/{angleB}/{angleC}/{R}") { backStackEntry ->
            val a = backStackEntry.arguments?.getString("a") ?: "A"
            val b = backStackEntry.arguments?.getString("b") ?: "B"
            val c = backStackEntry.arguments?.getString("c") ?: "C"

            val abStr = backStackEntry.arguments?.getString("ab") ?: "0.0"
            val bcStr = backStackEntry.arguments?.getString("bc") ?: "0.0"
            val acStr = backStackEntry.arguments?.getString("ac") ?: "0.0"
            val angleAStr = backStackEntry.arguments?.getString("angleA") ?: "0.0"
            val angleBStr = backStackEntry.arguments?.getString("angleB") ?: "0.0"
            val angleCStr = backStackEntry.arguments?.getString("angleC") ?: "0.0"

            val R = backStackEntry.arguments?.getString("R") ?: "0.0"

            val result = arrayListOf(
                abStr.toDoubleOrNull() ?: 0.0,
                bcStr.toDoubleOrNull() ?: 0.0,
                acStr.toDoubleOrNull() ?: 0.0,
                angleAStr.toDoubleOrNull() ?: 0.0,
                angleBStr.toDoubleOrNull() ?: 0.0,
                angleCStr.toDoubleOrNull() ?: 0.0,
                R.toDouble()
            )

            ResultPage(result = result, A = a, B = b, C = c)
        }
    }
}


