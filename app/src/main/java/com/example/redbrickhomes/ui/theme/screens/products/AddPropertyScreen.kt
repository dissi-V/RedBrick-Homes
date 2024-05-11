package com.example.redbrickhomes.ui.theme.screens.products

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.redbrickhomes.R
import com.example.redbrickhomes.data.PropertyViewModel
import com.example.redbrickhomes.navigation.HOME_URL
import com.example.redbrickhomes.navigation.VIEW_PROPERTY_URL
import com.example.redbrickhomes.ui.theme.Redd
import com.example.redbrickhomes.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPropertyScreen(navController:NavHostController){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .paint(painterResource(id = R.drawable.back4), contentScale = ContentScale.FillBounds)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopAppBar(
            title = {
                Text(
                    text = "Red Brick Homes"
        ) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Redd),
            navigationIcon = {
                IconButton(onClick = { navController.navigate(HOME_URL) }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "back",
                        tint = Color.Black


                    )
                }

            },




        )//End of top Topappbar
        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "Add Property",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )

        var propertyName by remember { mutableStateOf("") }
        var propertyLocation by remember { mutableStateOf("") }
        var propertyPrice by remember { mutableStateOf("") }
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = propertyName,
            onValueChange = { propertyName = it },
            label = { Text(text = "Property name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = propertyLocation,
            onValueChange = { propertyLocation = it },
            label = { Text(text = "Property location *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = propertyPrice,
            onValueChange = { propertyPrice = it },
            label = { Text(text = "Property price *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))



        //---------------------IMAGE PICKER START-----------------------------------//

        var modifier = Modifier
        ImagePicker(modifier,context, navController, propertyName.trim(), propertyLocation.trim(), propertyPrice.trim())

        //---------------------IMAGE PICKER END-----------------------------------//



    }
}

@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context,navController: NavHostController, name:String, location:String, price:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
                colors = ButtonDefaults.buttonColors(Redd)
            ) {
                Text(
                    text = "Select Image"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var propertyRepository = PropertyViewModel(navController,context)
                propertyRepository.uploadProperty(name, location, price,imageUri!!)
                             },
                colors = ButtonDefaults.buttonColors(Redd),
                modifier = Modifier.width(200.dp)
            ) {
                Text(
                    text = "Upload",
                    fontSize = 15.sp,)
            }
            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = "View Apartments",
                modifier = Modifier.clickable { navController.navigate(VIEW_PROPERTY_URL) },
            )



        }
    }
}

@Composable
@Preview(showBackground = true)
fun AddPropertyScreenPreview(){
    WazitoECommerceTheme {
        AddPropertyScreen(navController = rememberNavController())
    }
}