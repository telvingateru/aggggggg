package com.example.mycarstore.ui.theme.screens.home


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mycarstore.R
import com.example.mycarstore.navigation.AUDIQ7_URL
import com.example.mycarstore.navigation.COROLLA1_URL
import com.example.mycarstore.navigation.CROWN_URL
import com.example.mycarstore.navigation.CRV_URL
import com.example.mycarstore.navigation.CX3_URL
import com.example.mycarstore.navigation.CX5_URL
import com.example.mycarstore.navigation.EVOQUE_URL
import com.example.mycarstore.navigation.HARRIER1_URL
import com.example.mycarstore.navigation.HARRIER2_URL
import com.example.mycarstore.navigation.VOGUE_URL
import com.example.mycarstore.ui.theme.MyCarStoreTheme
import com.example.mycarstore.ui.theme.Orange

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavHostController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },


            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu")
                    }
                }
            },
            //Content Section
            content = @Composable{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())

                ){


                    // start of TopAppBar
                    TopAppBar(title = {
                        Text(
                            text = "CarStore",
                            color = Orange,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold

                        )
                    })

                    // End of TopAppBar
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .horizontalScroll(rememberScrollState())
                    ) {
                        Spacer(modifier = Modifier.width(10.dp))

                        Card(
                                elevation = CardDefaults.cardElevation(10.dp),

                            modifier = Modifier.clickable {
                                navController.navigate(route = HARRIER1_URL )
                            }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.harrier),
                                contentDescription = "evoque",
                                modifier = Modifier.size(width = 300.dp, height = 200.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(text = "Toyota Harrier")
                            Text(
                                text = "Ksh 6,450,000",
                                color = Color.Gray,
                                fontFamily = FontFamily.Cursive
                            )
                        }






                        Spacer(modifier = Modifier.width(10.dp))
                        //Start of column1

                        Card (
                            elevation = CardDefaults.cardElevation(10.dp),

                            modifier = Modifier.clickable {
                                navController.navigate(route = HARRIER2_URL)
                            }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.harrier2),
                                contentDescription = "evoque",
                                modifier = Modifier.size(width = 300.dp, height = 200.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(text = "Toyota Harrier")
                            Text(
                                text = "Ksh 9,450,000",
                                color = Color.Gray,
                                fontFamily = FontFamily.Cursive
                            )
                        }


                        //Start of column1

                        Card (
                            elevation = CardDefaults.cardElevation(10.dp),

                            modifier = Modifier.clickable {
                                navController.navigate(route = VOGUE_URL )
                            }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.vogue),
                                contentDescription = "evoque",
                                modifier = Modifier.size(width = 300.dp, height = 200.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(text = "Range Rover Vogue")
                            Text(
                                text = "Ksh 37,450,000",
                                color = Color.Gray,
                                fontFamily = FontFamily.Cursive
                            )
                        }
                    }





                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Text(
                            text = "Recommended",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                    }


                    //start of row 1
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        //Start of column1
                        Column(
                            modifier = Modifier
                                .padding(start = 5.dp)
                        ) {
                            Card (
                                elevation = CardDefaults.cardElevation(10.dp),

                                modifier = Modifier.clickable {
                                    navController.navigate(route = EVOQUE_URL )
                                }
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.evoque),
                                    contentDescription = "evoque",
                                    modifier = Modifier.size(width = 180.dp, height = 140.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Text(text = "Range Rover Evoque")
                            Text(
                                text = "Ksh 42,450,000",
                                color = Color.Gray,
                                fontFamily = FontFamily.Cursive
                            )

                        }
                        //Start of column2
                        Column(
                            modifier = Modifier
                                .padding(start = 20.dp)
                        ) {
                            Card(
                                elevation = CardDefaults.cardElevation(10.dp),

                                modifier = Modifier.clickable {
                                    navController.navigate(route = COROLLA1_URL )
                                }
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.corolla),
                                    contentDescription = "evoque",
                                    modifier = Modifier.size(width = 180.dp, height = 140.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Text(text = "Toyota Corolla")

                            Text(
                                text = "Ksh 1,450,000",
                                color = Color.Gray,
                                fontFamily = FontFamily.Cursive,
                            )

                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    //start of row 2
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        //Start of column1
                        Column(
                            modifier = Modifier
                                .padding(start = 5.dp)
                        ) {
                            Card (
                                elevation = CardDefaults.cardElevation(10.dp),

                                modifier = Modifier.clickable {
                                    navController.navigate(route = CRV_URL )
                                }
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.crv),
                                    contentDescription = "evoque",
                                    modifier = Modifier.size(width = 180.dp, height = 140.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Text(text = "Honda CR-V")
                            Text(
                                text = "Ksh 3,450,000",
                                color = Color.Gray,
                                fontFamily = FontFamily.Cursive
                            )

                        }
                        //Start of column2
                        Column(
                            modifier = Modifier
                                .padding(start = 20.dp)
                        ) {
                            Card (
                                elevation = CardDefaults.cardElevation(10.dp),

                                modifier = Modifier.clickable {
                                    navController.navigate(route = HARRIER1_URL )
                                }
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.vogue),
                                    contentDescription = "evoque",
                                    modifier = Modifier.size(width = 180.dp, height = 140.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Text(text = "Range Rover Vogue")

                            Text(
                                text = "Ksh 39,450,000",
                                color = Color.Gray,
                                fontFamily = FontFamily.Cursive,
                            )

                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    //start of row 3
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        //Start of column1
                        Column {

                            Card(
                                elevation = CardDefaults.cardElevation(10.dp),

                                modifier = Modifier.clickable {
                                    navController.navigate(route = CX3_URL )
                                }
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.cx3),
                                    contentDescription = "evoque",
                                    modifier = Modifier.size(width = 180.dp, height = 140.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Text(text = "Mazda CX-3")
                            Text(
                                text = "Ksh 2,450,000",
                                color = Color.Gray,
                                fontFamily = FontFamily.Cursive
                            )

                        }
                        //Start of column2
                        Column(
                            modifier = Modifier
                                .padding(start = 20.dp)
                        ) {
                            Card (
                                elevation = CardDefaults.cardElevation(10.dp),

                                modifier = Modifier.clickable {
                                    navController.navigate(route = CX5_URL )
                                }
                            )
                            {
                                Image(
                                    painter = painterResource(id = R.drawable.cx5),
                                    contentDescription = "evoque",
                                    modifier = Modifier.size(width = 180.dp, height = 140.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Text(text = "Mazda CX-5")

                            Text(
                                text = "Ksh 5,450,000",
                                color = Color.Gray,
                                fontFamily = FontFamily.Cursive,
                            )

                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    //start of row 4
                    Row(
                        modifier = Modifier.fillMaxWidth()
                               ) {
                        //Start of column1
                        Column(
                            modifier = Modifier
                                .padding(start = 5.dp)
                        ) {
                            Card (
                                elevation = CardDefaults.cardElevation(10.dp),
                            modifier =  Modifier.clickable{
                                    navController.navigate(AUDIQ7_URL)
                            })
                            {
                                Image(
                                    painter = painterResource(id = R.drawable.audiq7),
                                    contentDescription = "evoque",
                                    modifier = Modifier.size(width = 180.dp, height = 140.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Text(text = "Audi-Q7")
                            Text(
                                text = "Ksh 12,450,000",
                                color = Color.Gray,
                                fontFamily = FontFamily.Cursive
                            )

                        }
                        //Start of column2
                        Column(
                            modifier = Modifier
                                .padding(start = 20.dp)
                        ) {
                            Card (
                                elevation = CardDefaults.cardElevation(10.dp),

                                modifier = Modifier.clickable {
                                    navController.navigate(route = CROWN_URL )
                                }
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.crown2023),
                                    contentDescription = "evoque",
                                    modifier = Modifier.size(width = 180.dp, height = 140.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Text(text = "Toyota Crown model-2023")

                            Text(
                                text = "Ksh 10,450,000",
                                color = Color.Gray,
                                fontFamily = FontFamily.Cursive,
                            )

                        }

                    }

                }

            }

        )

    }
}



val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Rent",
        route="Rent",
        selectedIcon=Icons.Filled.Star,
        unselectedIcon=Icons.Outlined.Person,
        hasNews = true,
        badges=5
    ),

    BottomNavItem(
        title = "Sell",
        route="add_products",
        selectedIcon=Icons.Filled.ShoppingCart,
        unselectedIcon=Icons.Outlined.Face,
        hasNews = true,
        badges=1
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon :ImageVector,
    val hasNews :Boolean,
    val badges :Int
)



@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    MyCarStoreTheme {


        HomeScreen(navController = rememberNavController())
    }
}