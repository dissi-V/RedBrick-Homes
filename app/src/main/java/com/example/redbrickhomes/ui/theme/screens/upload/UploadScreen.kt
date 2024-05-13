package com.example.redbrickhomes.ui.theme.screens.upload

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.redbrickhomes.navigation.ADD_PROPERTY_URL
import com.example.redbrickhomes.ui.theme.Redd
import com.example.redbrickhomes.ui.theme.WazitoECommerceTheme
import com.example.redbrickhomes.ui.theme.screens.products.AddPropertyScreen

@Composable
fun UploadScreen(
    navController: NavHostController){
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .paint(painterResource(id = R.drawable.back4), contentScale = ContentScale.FillBounds)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current

        Text(text = "Uploaded Premises",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red)

        Spacer(modifier = Modifier.height(15.dp))

        Card(modifier = Modifier
            .height(320.dp)
            .width(300.dp)
            .padding(bottom = 10.dp)) {


            Image(
                painter = painterResource(id = R.drawable.apartment2),
                contentDescription = "newyork",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillBounds)

            Text(text = "Vipingoo",
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )

            Text(text = "Madzuu",
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )

            Text(text = "Ksh 120000",
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(5.dp))

            Row {
                Button(onClick = {

                },
                    shape = RoundedCornerShape(topStart = 10.dp),
                    colors = ButtonDefaults.buttonColors(Redd)
                ) {
                    Text(text = "Delete")
                }
                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = {
                    navController.navigate(ADD_PROPERTY_URL +"")
                },
                    shape = RoundedCornerShape(topStart = 10.dp),
                    colors = ButtonDefaults.buttonColors(Redd)
                ) {
                    Text(text = "Update")
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(modifier = Modifier
            .height(320.dp)
            .width(300.dp)
            .padding(bottom = 10.dp)) {


            Image(
                painter = painterResource(id = R.drawable.apartment2),
                contentDescription = "newyork",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillBounds)

            Text(text = "Westlands",
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )

            Text(text = "Kapombe",
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )

            Text(text = "Ksh 120000",
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(5.dp))

            Row {
                Button(onClick = {

                },
                    shape = RoundedCornerShape(topStart = 10.dp),
                    colors = ButtonDefaults.buttonColors(Redd)
                ) {
                    Text(text = "Delete")
                }
                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = {
                    navController.navigate(ADD_PROPERTY_URL +"")
                },
                    shape = RoundedCornerShape(topStart = 10.dp),
                    colors = ButtonDefaults.buttonColors(Redd)
                ) {
                    Text(text = "Update")
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Card(modifier = Modifier
            .height(320.dp)
            .width(300.dp)
            .padding(bottom = 10.dp)) {


            Image(
                painter = painterResource(id = R.drawable.apartment2),
                contentDescription = "newyork",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillBounds)

            Text(text = "Glenfiddich",
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )

            Text(text = "Massachusetts",
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )

            Text(text = "Ksh 120000",
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(5.dp))

            Row {
                Button(onClick = {

                },
                    shape = RoundedCornerShape(topStart = 10.dp),
                    colors = ButtonDefaults.buttonColors(Redd)
                ) {
                    Text(text = "Delete")
                }
                Spacer(modifier = Modifier.width(10.dp))

                Button(onClick = {
                    navController.navigate(ADD_PROPERTY_URL +"")
                },
                    shape = RoundedCornerShape(topStart = 10.dp),
                    colors = ButtonDefaults.buttonColors(Redd)
                ) {
                    Text(text = "Update")
                }
            }
        }


    }

}

@Composable
@Preview(showBackground = true)
fun UploadScreenPreview(){
    WazitoECommerceTheme {
    UploadScreen(navController = rememberNavController())
    }
}