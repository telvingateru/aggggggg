package com.example.mycarstore.ui.theme.screens.products

import android.content.Context
import com.google.firebase.storage.FirebaseStorage
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mycarstore.R
import com.example.mycarstore.data.ProductViewModel
import com.example.mycarstore.ui.theme.MyCarStoreTheme
import com.example.mycarstore.ui.theme.Orange
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductsScreen(navController:NavHostController){


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.car),
                contentDescription = "evoque",
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
            )
            Text(
                text = "Sell your car",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Orange,
                fontFamily = FontFamily.Serif
            )

        }

        var carmodel by remember { mutableStateOf("") }
        var carbrand by remember { mutableStateOf("") }
        var price by remember { mutableStateOf("") }
        var mileage by remember { mutableStateOf("") }
        var enginesize by remember { mutableStateOf("") }
        var fueltype by remember { mutableStateOf("") }
        var transmission by remember { mutableStateOf("") }
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = carmodel,
            onValueChange = { carmodel = it },
            label = { Text(text = "Product name ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)                                                                                                                                            
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = carbrand,
            onValueChange = { carbrand = it },
            label = { Text(text = " carbrand ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = price ,
            onValueChange = { price  = it },
            label = { Text(text = "price ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(10.dp))
                                             
        OutlinedTextField(
            value = mileage,
            onValueChange = { mileage = it },
            label = { Text(text = "mileage") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = enginesize,
            onValueChange = { enginesize = it },
            label = { Text(text = "enginesize") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(10.dp))

        val list = listOf("diesel","Petrol","Hybrid(diesel)","Hydrid(petrol)")
        var isExpanded by remember { mutableStateOf(false) }


        Row {
            ExposedDropdownMenuBox(expanded = true,
                onExpandedChange = {isExpanded = !isExpanded})
            {
                   OutlinedTextField(
                    value = fueltype,
                    onValueChange = { fueltype = it },
                    label = { Text(text = "fueltype") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    singleLine = true,
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)}
                )
                ExposedDropdownMenu(expanded = isExpanded,
                    onDismissRequest = { isExpanded = false}) {
                    list.forEachIndexed{index,text ->
                        DropdownMenuItem(text = { Text(text = text) },
                            onClick = {
                                fueltype = list[index]
                                isExpanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            val list1 = listOf("Automatic","Manual")
            var isExpanded by remember { mutableStateOf(false) }

            ExposedDropdownMenuBox(expanded = true,
                onExpandedChange = {isExpanded = !isExpanded})
            {
                OutlinedTextField(
                    value = transmission,
                    onValueChange = { transmission = it },
                    label = { Text(text = "transmission") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    singleLine = true,
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)}
                )
                ExposedDropdownMenu(expanded = isExpanded,
                    onDismissRequest = { isExpanded = false}) {
                    list1.forEachIndexed{index,text ->
                        DropdownMenuItem(text = { Text(text = text) },
                            onClick = {
                                transmission = list1[index]
                                isExpanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }
        }




        Spacer(modifier = Modifier.height(10.dp))




    }
}

@Composable
fun SelectImagesScreen(onImagesSelected: (List<Uri>) -> Unit) {
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetMultipleContents()
    ) { uris ->
        onImagesSelected(uris)
    }

    Button(onClick = { launcher.launch("image/*") }) {
        Text("Select Images")
    }
}


fun uploadImages(uris: List<Uri>, onUploadSuccess: (List<String>) -> Unit, onUploadFailure: (Exception) -> Unit) {
    val storage = FirebaseStorage.getInstance()
    val scope = CoroutineScope(Dispatchers.IO)

    val uploadedUrls = mutableListOf<String>()

    scope.launch {
        try {
            uris.forEach { uri ->
                val fileName = UUID.randomUUID().toString()
                val storageRef = storage.reference.child("images/$fileName")

                storageRef.putFile(uri).await()  // Wait until the upload is completed
                val downloadUrl = storageRef.downloadUrl.await()

                uploadedUrls.add(downloadUrl.toString())
            }
            onUploadSuccess(uploadedUrls)  // Return the list of download URLs
        } catch (e: Exception) {
            onUploadFailure(e)
        }
    }
}


@Composable
@Preview(showBackground = true)
fun AddProductsScreenPreview(){

        AddProductsScreen(navController = rememberNavController())

}