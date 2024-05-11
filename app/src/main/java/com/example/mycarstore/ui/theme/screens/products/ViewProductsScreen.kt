package com.example.mycarstore.ui.theme.screens.products

import android.net.Uri
import android.view.Display
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
fun DisplayScreen () {
    val pvm= ProductViewModel()
    var fetchedData by remember { mutableState0f<List<Product> ?> (  null) }
    var errorMessage by remember { mutableState0f<$tring?> (  null) }
    val mContext = LocalContext. current
            LaunchedEffect (Unit) {
                pvm.fetchData ( " employee", context =mContext ) { data, error ->
                    if (error != null) {
                        Toast.makeText (mContext, error, Toast. LENGTH_SHORT). show()
                                errorMessage = error
                    } else {
                        Toast.makeText (mContext, "Success" , Toast. LENGTH_SHORT).show()
                        fetchedData = data
                    }
                }
            }
                        if (fetchedData != null) {
                            // Display fetched data
                            // For example , you can use a LazyColumn to display a list of items
                            LazyColumn {
                                itemsIndexed (fetchedData !!){index, item ->

                                Card(
                                    modifier = Modifier . padding (8. dp)
                                ) {
                                    Column (
                                        modifier = Modifier
                                            .padding (8. dp)
                                            .fillMaxWidth ()
                                    ) {
                                        Spacer (modifier = Modifier.width (5. dp) )
                                        Column {
                                            Text(
                                                text = "Product Name :",
                                                fontWeight = FontWeight. Bold,
                                                fontSize = 15.sp
                                            )
                                                        fetchedData !! [index] . productName.let {
                                                            it?.let { it1 ->
                                                                Text(
                                                                    text = it1,
                                                                    modifier = Modifier.padding(4.dp),
                                                                    color = Color.Black,
                                                                    textAlign = TextAlign.Center,
                                                                    fontSize = 15.sp,
                                                                    fontWeight = FontWeight.Bold
                                                                )
                                                            }
                                                        }
                                            Text(text = "Product Description:",
                                                fontWeight = FontWeight. Bold,
                                                fontSize = 15.sp
                                            )
                                                        fetchedData!! [index].productDescription. let {
                                                        it?.let { it1 ->
                                                            Text(
                                                                text = it1,
                                                                modifier = Modifier
                                                                    .padding (4.dp),
                                                                        color = Color.Black,

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