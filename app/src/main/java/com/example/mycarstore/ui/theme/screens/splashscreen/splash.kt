package com.example.mycarstore.ui.theme.screens.splashscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycarstore.R
import com.example.mycarstore.navigation.SIGNUP_URL
import com.example.mycarstore.ui.theme.Orange
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavHostController){

        Column (modifier = Modifier
                .fillMaxSize()
                .background(color = Orange),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
        ){
                val coroutine = rememberCoroutineScope()
                coroutine.launch {
                        delay(3000)
                        navController.navigate(SIGNUP_URL)
                }
                Image(painter= painterResource(id = R.drawable.car),
                        contentDescription ="Car",
                        modifier = Modifier
                                .size(100.dp),
                        contentScale = ContentScale.Crop


                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(text ="CarStore",
                        fontSize = 35.sp,


                )
        }


        }





@Composable
@Preview(showBackground = true)
fun SplashScreenPreview(){

        SplashScreen(navController = rememberNavController())


}