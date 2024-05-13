package com.example.redbrickhomes.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.redbrickhomes.R
import com.example.redbrickhomes.data.AuthViewModel
import com.example.redbrickhomes.navigation.SIGNUP_URL
import com.example.redbrickhomes.ui.theme.Redd
import com.example.redbrickhomes.ui.theme.WazitoECommerceTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController:NavHostController){
    Column(
        modifier = Modifier
            .paint(painterResource(id = R.drawable.back4), contentScale = ContentScale.FillBounds)
            .fillMaxSize()
            .padding(top = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.homeicon3),
            contentDescription = "homeicon",
            modifier = Modifier.size(100.dp))

        Text(
            text = "Welcome Back",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        Spacer(modifier = Modifier.height(30.dp))

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Enter email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email")}
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Enter password")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "lock")}
        )

        Spacer(modifier = Modifier.height(30.dp))
        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

        Button(onClick = {
            authViewModel.login(email, password)
        },
            colors = ButtonDefaults.buttonColors(Redd),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Don't have an account? Sign up",
            fontSize = 15.sp,
            modifier = Modifier
                .clickable { navController.navigate(SIGNUP_URL) }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    WazitoECommerceTheme {
        LoginScreen(navController = rememberNavController())
    }
}