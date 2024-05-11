package com.example.mycarstore.ui.theme.screens.products

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.mycarstore.data.ProductViewModel
import com.example.mycarstore.models.Product
import com.example.mycarstore.data.ProductViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@Composable
fun ViewProductsScreen(navController:NavHostController) {
    var selectedImages by remember { mutableStateOf<List<Uri>?>(null) }
    var isUploading by remember { mutableStateOf(false) }
    var uploadError by remember { mutableStateOf<Exception?>(null) }
    val scope = CoroutineScope(Dispatchers.Main)
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var productRepository = ProductViewModel(navController, context)


        val emptyProductState = remember { mutableStateOf(Product("","","","","")) }
        var emptyProductsListState = remember { mutableStateListOf<Product>() }

        var products = productRepository.allProducts(emptyProductState, emptyProductsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All products",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(products){
                    ProductItem(
                        name = it.name,
                        quantity = it.quantity,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository,
                        productImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun ProductItem(name:String, quantity:String, price:String, id:String,
                navController:NavHostController,
                productRepository:ProductViewModel, productImage:String) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = quantity)
        Text(text = price)
        Image(
            painter = rememberAsyncImagePainter(productImage),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Button(onClick = {
            productRepository.deleteProduct(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            //navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewProductsScreenPreview(){

        ViewProductsScreen(navController = rememberNavController())

}