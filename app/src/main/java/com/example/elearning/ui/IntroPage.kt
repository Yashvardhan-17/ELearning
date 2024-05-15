package com.example.elearning.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.elearning.R

@Composable
fun introPage(navController: NavController){

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(painter = painterResource(R.drawable.intro_page_image),
            contentDescription = "intro image",
            )
        Text(
            text = "Online Learning Platform",
            modifier = Modifier
                .padding(top=16.dp, bottom = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF874ECF)
        )
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 20.dp,
                    start = 20.dp, end = 20.dp)
        )
        Button(onClick = {navController.navigate(Screen.LoginPage.route)},
            colors = ButtonDefaults.buttonColors(Color(0xFF874ECF)),
            modifier = Modifier
                .width(250.dp)
                .height(45.dp)
        ) {
                Text(text = "Start Learning",
                    fontSize = 16.sp,
                    modifier=Modifier
                        .background(Color(0xFF874ECF))
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun introPagePreview(){
    val navController = rememberNavController()
    introPage(navController)

}

