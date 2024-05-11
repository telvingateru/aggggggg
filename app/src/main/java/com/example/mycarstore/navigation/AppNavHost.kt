package com.example.mycarstore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycarstore.ui.theme.screens.audi.Audiq7Screen
import com.example.mycarstore.ui.theme.screens.audi.CorollaScreen
import com.example.mycarstore.ui.theme.screens.audi.CrownScreen
import com.example.mycarstore.ui.theme.screens.audi.CrvScreen
import com.example.mycarstore.ui.theme.screens.audi.Cx3Screen
import com.example.mycarstore.ui.theme.screens.audi.Cx5Screen
import com.example.mycarstore.ui.theme.screens.audi.EvoqueScreen
import com.example.mycarstore.ui.theme.screens.audi.Harrier1Screen
import com.example.mycarstore.ui.theme.screens.audi.Harrier2Screen
import com.example.mycarstore.ui.theme.screens.audi.VitzScreen
import com.example.mycarstore.ui.theme.screens.audi.VogueScreen
import com.example.mycarstore.ui.theme.screens.home.HomeScreen
import com.example.mycarstore.ui.theme.screens.login.LoginScreen
import com.example.mycarstore.ui.theme.screens.products.AddProductsScreen
import com.example.mycarstore.ui.theme.screens.products.ViewProductsScreen
import com.example.mycarstore.ui.theme.screens.sell.SellScreen
import com.example.mycarstore.ui.theme.screens.signup.SignupScreen
import com.example.mycarstore.ui.theme.screens.splashscreen.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = SPLASH_URL
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
        composable(ADD_PRODUCTS_URL){
            AddProductsScreen(navController = navController)
        }
        composable(VIEW_PRODUCTS_URL){
            ViewProductsScreen(navController = navController)
        }
        composable(SPLASH_URL){
            SplashScreen(navController = navController)
        }
        composable(AUDIQ7_URL){
            Audiq7Screen(navController = navController)
        }
        composable(SELL_URL){
            SellScreen(navController = navController)
        }
        composable(COROLLA1_URL){
            CorollaScreen(navController =  navController)
        }
        composable(CRV_URL){
            CrvScreen(navController =  navController)
        }
        composable(CX3_URL){
            Cx3Screen(navController =  navController)
        }
        composable(CX5_URL){
            Cx5Screen(navController =  navController)
        }
        composable(EVOQUE_URL){
            EvoqueScreen(navController = navController)
        }
        composable(HARRIER1_URL){
            Harrier1Screen(navController =  navController)
        }
        composable(HARRIER2_URL){
            Harrier2Screen(navController =  navController)
        }
        composable(VITZ_URL){
            VitzScreen(navController =  navController)
        }
        composable(VOGUE_URL){
            VogueScreen(navController = navController)
        }
        composable(CROWN_URL){
            CrownScreen(navController = navController)
        }

    }
}