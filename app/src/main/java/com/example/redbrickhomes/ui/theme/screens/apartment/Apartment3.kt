package com.example.redbrickhomes.ui.theme.screens.apartment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.redbrickhomes.R
import com.example.redbrickhomes.navigation.HOME_URL
import com.example.redbrickhomes.ui.theme.Redd

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Apartment3Screen(navController: NavHostController){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
    ) {
        val mContext = LocalContext.current

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

        Card(
            modifier = Modifier
                .padding(start = 20.dp, top = 30.dp)
                .height(250.dp)
                .width(330.dp)
        ){
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center){
                Image(
                    painter = painterResource(id = R.drawable.apart1),
                    contentDescription = "newyork",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )

            }

        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Cherry Valley",
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))


        Text(
            text = "Located at Highridge, Nairobi",
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Overview",
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Property Type:     Single Family",
            fontSize = 13.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Building Type:     Apartment",
            fontSize = 13.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Property Status:     Available",
            fontSize = 13.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Furnishing:     Semi-furnished",
            fontSize = 13.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(start = 30.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Rent",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.padding(start = 30.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(modifier = Modifier.padding(start = 30.dp))
        {
            Text(
                text = "Single Bedroom:",
                fontSize = 13.sp,
                fontFamily = FontFamily.Serif
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "Ksh 38,000",
                fontSize = 14.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Redd

            )
        }

        Row(modifier = Modifier.padding(start = 30.dp))
        {
            Text(
                text = "Two Bedroom:",
                fontSize = 13.sp,
                fontFamily = FontFamily.Serif
            )
            Spacer(modifier = Modifier.width(26.dp))
            Text(
                text = "Ksh 38,000",
                fontSize = 14.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                color = Redd

            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val simToolKitLaunchIntent =
                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolKitLaunchIntent?.let { mContext.startActivity(it) }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Redd)
        ) {
            Text(text = "Book Now")
        }







    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Apartment3ScreenPreview(){
    Apartment3Screen(rememberNavController())
}