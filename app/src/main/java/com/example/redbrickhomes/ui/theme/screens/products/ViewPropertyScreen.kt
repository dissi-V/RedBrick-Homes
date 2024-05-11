package com.example.redbrickhomes.ui.theme.screens.products

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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.redbrickhomes.R
import com.example.redbrickhomes.data.PropertyViewModel
import com.example.redbrickhomes.models.Property
import com.example.redbrickhomes.navigation.ADD_PROPERTY_URL
import com.example.redbrickhomes.ui.theme.WazitoECommerceTheme

@Composable
fun ViewPropertyScreen(navController:NavHostController) {
    Column(modifier = Modifier
        .paint(painterResource(id = R.drawable.back4), contentScale = ContentScale.FillBounds)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var propertyRepository = PropertyViewModel(navController, context)


        val emptyPropertyState = remember { mutableStateOf(Property("","","","","")) }
        var emptyPropertiesListState = remember { mutableStateListOf<Property>() }

        var properties = propertyRepository.allProperty(emptyPropertyState, emptyPropertiesListState)


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
                items(properties){
                    PropertyItem(
                        name = it.name,
                        location = it.location,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        propertyRepository = propertyRepository,
                        propertyImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun PropertyItem(name:String, location:String, price:String, id:String,
                navController:NavHostController,
                propertyRepository:PropertyViewModel, propertyImage:String) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = rememberAsyncImagePainter(propertyImage),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Text(text = name)
        Text(text = location)
        Text(text = price)

        Button(onClick = {
            propertyRepository.deleteProperty(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ADD_PROPERTY_URL+"")
        }) {
            Text(text = "Update")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewPropertyScreenPreview(){
    WazitoECommerceTheme {
        ViewPropertyScreen(navController = rememberNavController())
    }
}