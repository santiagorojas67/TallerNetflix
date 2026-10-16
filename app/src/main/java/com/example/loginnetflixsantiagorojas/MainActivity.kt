package com.example.loginnetflixsantiagorojas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginnetflixsantiagorojas.navigation.Routes
import com.example.loginnetflixsantiagorojas.ui.screens.*
import com.example.loginnetflixsantiagorojas.ui.theme.LoginNetflixSantiagoRojasTheme
import com.example.loginnetflixsantiagorojas.ui.theme.NetflixBlack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginNetflixSantiagoRojasTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize(), containerColor = NetflixBlack) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Routes.LOGIN,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Routes.LOGIN) {
                            LoginScreen(
                                onLoginClick = { navController.navigate(Routes.HOME) },
                                onRegisterClick = { navController.navigate(Routes.REGISTER) }
                            )
                        }
                        composable(Routes.REGISTER) {
                            RegisterScreen(
                                onBackClick = { navController.popBackStack() },
                                onNextClick = { navController.navigate(Routes.REGISTER2) }
                            )
                        }
                        composable(Routes.REGISTER2) {
                            RegisterStep2Screen(
                                onBackClick = { navController.popBackStack() },
                                onNextClick = { navController.navigate(Routes.REGISTER3) }
                            )
                        }
                        composable(Routes.REGISTER3) {
                            RegisterStep3Screen(
                                onBackClick = { navController.popBackStack() },
                                onNextClick = {
                                    navController.navigate(Routes.HOME) {
                                        popUpTo(Routes.LOGIN) { inclusive = true }
                                    }
                                }
                            )
                        }
                        composable(Routes.HOME) {
                            HomeScreen(
                                onLogoutClick = {
                                    navController.navigate(Routes.LOGIN) {
                                        popUpTo(Routes.HOME) { inclusive = true }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}