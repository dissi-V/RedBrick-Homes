package com.example.redbrickhomes.ui.theme.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.redbrickhomes.R
import com.example.redbrickhomes.navigation.ADD_PROPERTY_URL
import com.example.redbrickhomes.navigation.APARTMENT1_URL
import com.example.redbrickhomes.navigation.APARTMENT2_URL
import com.example.redbrickhomes.navigation.APARTMENT3_URL
import com.example.redbrickhomes.navigation.APARTMENT4_URL
import com.example.redbrickhomes.navigation.HOUSE1_URL
import com.example.redbrickhomes.navigation.HOUSE2_URL
import com.example.redbrickhomes.navigation.HOUSE3_URL
import com.example.redbrickhomes.navigation.HOUSE4_URL
import com.example.redbrickhomes.ui.theme.Redd
import com.example.redbrickhomes.ui.theme.WazitoECommerceTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize(),
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
                    IconButton(onClick = { navController.navigate(ADD_PROPERTY_URL) }) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu")
                    }
                }
            },
            //Content Section
            content = @Composable{
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    val mContext = LocalContext.current

                    TopAppBar(
                        title = { Text(
                            text = "Red Brick Homes",
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp)
                        },
                        colors = TopAppBarDefaults.mediumTopAppBarColors(Redd),


                        )
                    //End of Topapp bar

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.bedroom1) ,
                            contentDescription = "newyork",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Here is where you find an ample premise to settle with family and also chill out with friends.",
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                    //End of box
                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Available Premises",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(start = 20.dp)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .padding(start = 6.dp)
                    ) {
                        // Column1
                        Column {
                            Card(
                                modifier = Modifier
                                    .clickable { navController.navigate(HOUSE1_URL) }
                                    .height(100.dp)
                                    .width(160.dp)
                            ){
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center){
                                    Image(
                                        painter = painterResource(id = R.drawable.house2),
                                        contentDescription = "newyork",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Bungalow House",
                                fontSize = 18.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "House",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                        }
                        //End of Column1

                        Spacer(modifier = Modifier.width(15.dp))

                        // Column1
                        Column {
                            Card(
                                modifier = Modifier
                                    .clickable { navController.navigate(APARTMENT1_URL) }
                                    .height(100.dp)
                                    .width(160.dp)
                            ){
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center){
                                    Image(
                                        painter = painterResource(id = R.drawable.apartment3),
                                        contentDescription = "newyork",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Konza Estate",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Apartment",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                        }
                        //End of Column1



                    }
                    //End of Row1

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .padding(start = 6.dp)
                    ) {
                        // Column1
                        Column {
                            Card(
                                modifier = Modifier
                                    .clickable { navController.navigate(APARTMENT2_URL) }
                                    .height(100.dp)
                                    .width(160.dp)
                            ){
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center){
                                    Image(
                                        painter = painterResource(id = R.drawable.apartment2),
                                        contentDescription = "newyork",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "BrumbleVille",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Apartment",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                        }
                        //End of Column1

                        Spacer(modifier = Modifier.width(15.dp))

                        // Column1
                        Column {
                            Card(
                                modifier = Modifier
                                    .clickable { navController.navigate(APARTMENT3_URL) }
                                    .height(100.dp)
                                    .width(160.dp)
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

                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Cherry Valley",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Apartment",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                        }
                        //End of Column1



                    } //End of Row2

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .padding(start = 6.dp)
                    ) {
                        // Column1
                        Column {
                            Card(
                                modifier = Modifier
                                    .clickable { navController.navigate(HOUSE2_URL) }
                                    .height(100.dp)
                                    .width(160.dp)
                            ){
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center){
                                    Image(
                                        painter = painterResource(id = R.drawable.house4),
                                        contentDescription = "newyork",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Bloom Chalet",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "House",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                        }
                        //End of Column1

                        Spacer(modifier = Modifier.width(15.dp))

                        // Column1
                        Column {
                            Card(
                                modifier = Modifier
                                    .clickable { navController.navigate(HOUSE3_URL) }
                                    .height(100.dp)
                                    .width(160.dp)
                            ){
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center){
                                    Image(
                                        painter = painterResource(id = R.drawable.house3),
                                        contentDescription = "newyork",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Elopers Haven",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "House",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                        }
                        //End of Column1



                    } //End of Row3

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .padding(start = 6.dp)
                    ) {
                        // Column1
                        Column {
                            Card(
                                modifier = Modifier
                                    .clickable { navController.navigate(APARTMENT4_URL) }
                                    .height(100.dp)
                                    .width(160.dp)
                            ){
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center){
                                    Image(
                                        painter = painterResource(id = R.drawable.apartment4),
                                        contentDescription = "newyork",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "W Palace",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Apartment",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                        }
                        //End of Column1

                        Spacer(modifier = Modifier.width(15.dp))

                        // Column1
                        Column {
                            Card(
                                modifier = Modifier
                                    .clickable { navController.navigate(HOUSE4_URL) }
                                    .height(100.dp)
                                    .width(160.dp)
                            ){
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center){
                                    Image(
                                        painter = painterResource(id = R.drawable.house5),
                                        contentDescription = "newyork",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Comfy Stables",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "House",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif
                            )
                            
                            Spacer(modifier = Modifier.height(2.dp))


                        }
                        //End of Column1



                    } //End of Row4
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .padding(start = 6.dp)
                    ) {
                        // Column1
                        Column {
                            Card(
                                modifier = Modifier
                                    .height(100.dp)
                                    .width(160.dp)
                            ){
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center){
                                    Image(
                                        painter = painterResource(id = R.drawable.apartment5),
                                        contentDescription = "newyork",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Haven Court",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "Apartment",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                        }
                        //End of Column1

                        Spacer(modifier = Modifier.width(15.dp))

                        // Column1
                        Column {
                            Card(
                                modifier = Modifier
                                    .height(100.dp)
                                    .width(160.dp)
                            ){
                                Box(modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.Center){
                                    Image(
                                        painter = painterResource(id = R.drawable.house5),
                                        contentDescription = "newyork",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.FillBounds
                                    )

                                }

                            }

                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "Cuddles Crib",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                            Text(
                                text = "House",
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif
                            )
                            Spacer(modifier = Modifier.height(2.dp))


                        }
                        //End of Column1



                    } //End of Row5

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
        title = "Login",
        route="login",
        selectedIcon=Icons.Filled.Person,
        unselectedIcon=Icons.Outlined.Person,
        hasNews = true,
        badges=5
    ),

    BottomNavItem(
        title = "Signup",
        route="signup",
        selectedIcon=Icons.Filled.Face,
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
    WazitoECommerceTheme {
        HomeScreen(navController = rememberNavController())
    }
}