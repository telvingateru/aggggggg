package com.example.mycarstore.ui.theme.screens.products

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.mycarstore.R
import com.example.mycarstore.data.ProductViewModel
import com.example.mycarstore.models.Product
import com.example.mycarstore.navigation.ADD_PRODUCTS_URL

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewProductScreen(navController: NavHostController) {
    Column(modifier = Modifier

        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {



        var context = LocalContext.current
        var productRepository = ProductViewModel(navController, context)


        val emptyProductState = remember { mutableStateOf(Product("","","","","","","","")) }
        var emptyProductsListState = remember { mutableStateListOf<Product>() }

        var products = productRepository.allProducts(emptyProductState, emptyProductsListState)



        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row{
                Image(painter = painterResource(id = R.drawable.car), contentDescription = "spanner",
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(50.dp)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(text = "CarStore",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }

            LazyColumn(){

                items(products){

                    ViewItem(

                        productImage = it.imageUrl,

                        carmodel = it.carmodel,

                        price = it.price,

                        carbrand = it.carbrand,

                        mileage = it.mileage,

                        enginesize = it.enginesize,

                        fueltype = it.fueltype,

                        transmission = it.transmission,

                        navController = navController,

                        productRepository = productRepository

                    )

                }

            }
        }
    }
}

@Composable
fun ViewItem(
    carbrand: String,
    price: String,
    carmodel: String,
    mileage: String,
    transmission: String,
    fueltype: String,
    navController: NavHostController,
    productRepository: ProductViewModel,
    productImage: String,
    enginesize: String
) {

    Card (modifier = Modifier
        .padding(top = 20.dp)
        .height(300.dp)
        .width(240.dp)){
        Column (modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = rememberAsyncImagePainter(productImage),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(bottom = 5.dp, start = 20.dp, end = 20.dp, top = 10.dp)
                    .size(150.dp)
            )
            Column (modifier = Modifier
                .padding(start = 25.dp)
                .fillMaxWidth(),
                horizontalAlignment = AbsoluteAlignment.Left
            ){
                Row {
                    Text(text = "carbrand:", fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 5.dp, start = 10.dp))

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(text = carbrand, fontSize = 18.sp,
                        textAlign = TextAlign.Left,
                        fontFamily = FontFamily.Serif,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 5.dp))
                }

                Row {
                    Text(text = "Price:",fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 5.dp, start = 10.dp))

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(text = "Ksh.$price",fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 5.dp))
                }

                Row {
                    Text(text = "carmodel:",fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 10.dp, start = 10.dp))

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(text = carmodel,fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 10.dp))
                }

                Row {
                    Text(text = "mileage:",fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 10.dp, start = 10.dp))

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(text = mileage,fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 10.dp))
                }

                Row {
                    Text(text = "enginesize:",fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 10.dp, start = 10.dp))

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(text = enginesize,fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 10.dp))
                }

                Row {
                    Text(text = "fueltype:",fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 10.dp, start = 10.dp))

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(text = fueltype,fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 10.dp))
                }

                Row {
                    Text(text = "transmission:",fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 10.dp, start = 10.dp))

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(text = transmission,fontSize = 18.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Black, modifier =
                        Modifier
                            .padding(bottom = 10.dp))
                }

            }
            Row {
                Text(text = "DELETE",
                    Modifier
                        .clickable { productRepository.deleteProduct(fueltype) }
                        .padding(bottom = 5.dp, start = 10.dp),
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(text = "UPDATE",
                    Modifier
                        .clickable { navController.navigate(ADD_PRODUCTS_URL) }
                        .padding(bottom = 5.dp, start = 10.dp),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold
                )

            }

        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}
@Composable
@Preview(showBackground = true)
fun ViewProductsScreenPreview(){

        ViewProductScreen(navController = rememberNavController())

}