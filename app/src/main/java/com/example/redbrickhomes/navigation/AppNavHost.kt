package com.example.redbrickhomes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.redbrickhomes.ui.theme.screens.apartment.Apartment1Screen
import com.example.redbrickhomes.ui.theme.screens.apartment.Apartment2Screen
import com.example.redbrickhomes.ui.theme.screens.apartment.Apartment3Screen
import com.example.redbrickhomes.ui.theme.screens.apartment.Apartment4Screen
import com.example.redbrickhomes.ui.theme.screens.home.HomeScreen
import com.example.redbrickhomes.ui.theme.screens.house.House1Screen
import com.example.redbrickhomes.ui.theme.screens.house.House2Screen
import com.example.redbrickhomes.ui.theme.screens.house.House3Screen
import com.example.redbrickhomes.ui.theme.screens.house.House4Screen
import com.example.redbrickhomes.ui.theme.screens.login.LoginScreen
import com.example.redbrickhomes.ui.theme.screens.products.AddPropertyScreen
import com.example.redbrickhomes.ui.theme.screens.products.ViewPropertyScreen
import com.example.redbrickhomes.ui.theme.screens.signup.SignupScreen
import com.example.redbrickhomes.ui.theme.screens.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = LOGIN_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }
        composable(HOME_URL){
            HomeScreen(navController = navController)
        }
        composable(ADD_PROPERTY_URL){
            AddPropertyScreen(navController = navController)
        }
        composable(VIEW_PROPERTY_URL){
            ViewPropertyScreen(navController = navController)
        }
        composable(SPLASH_URL){
            SplashScreen(navController = navController)
        }
        composable(HOUSE1_URL){
            House1Screen(navController = navController)
        }
        composable(HOUSE2_URL){
            House2Screen(navController = navController)
        }
        composable(HOUSE3_URL){
            House3Screen(navController = navController)
        }
        composable(HOUSE4_URL){
            House4Screen(navController = navController)
        }
        composable(APARTMENT1_URL){
            Apartment1Screen(navController = navController)
        }
        composable(APARTMENT2_URL){
            Apartment2Screen(navController = navController)
        }
        composable(APARTMENT3_URL){
            Apartment3Screen(navController = navController)
        }
        composable(APARTMENT4_URL){
            Apartment4Screen(navController = navController)
        }

    }
}