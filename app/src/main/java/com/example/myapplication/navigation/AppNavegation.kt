package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screens.LoginScreen
import com.example.myapplication.screens.MainScreen
import com.example.myapplication.screens.SignUpScreen
import com.example.myapplication.screens.WelcomeScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable("signUp") {
            SignUpScreen(navController)
        }
        composable("main") {
            MainScreen(navController)
        }
    }
}