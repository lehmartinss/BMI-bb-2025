package br.senai.sp.jandira.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.bmi.screens.BMIResultScreen
import br.senai.sp.jandira.bmi.screens.TelaInicial
import br.senai.sp.jandira.bmi.screens.UserdataScreen
import br.senai.sp.jandira.bmi.ui.theme.BMITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BMITheme {
              var navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ){
                    composable(
                        route = "home"
                    ){
                        TelaInicial(navController)
                    }
                    composable(
                        route = "user_data"
                    ){
                        UserdataScreen(navController)
                    }
                    composable(
                        route = "result_screen"
                    ){
                        BMIResultScreen(navController)
                    }
                }
            }
        }
    }
}
