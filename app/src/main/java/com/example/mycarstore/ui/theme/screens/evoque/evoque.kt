package com.example.mycarstore.ui.theme.screens.audi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mycarstore.R
import com.example.mycarstore.ui.theme.MyCarStoreTheme
import com.example.mycarstore.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EvoqueScreen(navController: NavHostController) {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Card {
                Image(
                    painter = painterResource(id = R.drawable.evoque),
                    contentDescription = "evoque",
                    modifier = Modifier.size(width = 400.dp, height = 350.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Card {
                Image(
                    painter = painterResource(id = R.drawable.evoque2),
                    contentDescription = "evoque",
                    modifier = Modifier.size(width = 300.dp, height = 250.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Card {
                Image(
                    painter = painterResource(id = R.drawable.evoque3),
                    contentDescription = "evoque",
                    modifier = Modifier.size(width = 300.dp, height = 250.dp),
                    contentScale = ContentScale.Crop
                )
            }



        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Range Rover Evoque",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Text(text = "Ksh 12,450,000")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "PROPERTIES",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp,
            color = Orange,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(10.dp))

        Column {
            Text(text = "1. 335 HP V6")
            Text(text = "2. Rear Parking Camera")
            Text(text = "3. cruise control")
            Text(text = "4. Engine Immobilizer")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Spacer(modifier = Modifier.width(46.dp))

        OutlinedButton(
            onClick = {  },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Color.White),
            border = BorderStroke(2.dp, Color.Gray),
            modifier = Modifier
                .width(300.dp)
                .height(50.dp)

        ) {
            Text(
                text = "Buy",
                color = Orange,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 33.sp
            )
        }


    }
}
@Composable
@Preview(showBackground = true)
fun EvoqueScreenPreview(){
    MyCarStoreTheme {


        EvoqueScreen(navController = rememberNavController())
    }
}
