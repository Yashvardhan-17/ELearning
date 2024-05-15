package com.example.elearning


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Book

import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.elearning.ui.MyAccountApp
import com.example.elearning.ui.Screen
import com.example.elearning.ui.SetupNavGraph
import com.example.elearning.ui.introPage
import com.example.elearning.ui.startScreen
import com.example.elearning.ui.theme.ELearningTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ELearningTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Myapp()
                }
            }
        }
    }
}
@Composable
fun Myapp(){
    val navController = rememberNavController()
    var isLoading by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = true){
        delay(2000)
        isLoading= false
    }

    if(isLoading){
        startScreen()
    }
    else{
        SetupNavGraph(navController = navController)
    }
}

@Composable
fun Title(){
        Text(text = "Learning App",
            color = Color(0xFF874ECF),
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 100.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium
        )
}


@Composable
fun FooterComponent(navController: NavController) {
    Row(
        modifier = Modifier
            .padding(top = 700.dp)
            .fillMaxWidth()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 30.dp)
                .clickable { navController.navigate(Screen.HomePage.route) }

        ) {
            Icon(Icons.Default.Home, contentDescription = "Home", tint =  Color(0xFF874ECF))
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "Home", color = Color(0xFF874ECF))
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 80.dp)
                .clickable { navController.navigate(Screen.MyClasses.route) }

        ) {
            Icon(Icons.Default.Book, contentDescription = "My Courses",tint =  Color(0xFF874ECF))
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "My Course", color =  Color(0xFF874ECF))
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(start = 80.dp)
                .clickable { navController.navigate(Screen.MyAccount.route) }

        ) {
            Icon(Icons.Default.AccountBox, contentDescription = "Account",tint =  Color(0xFF874ECF))
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "Account", color =  Color(0xFF874ECF))
        }

    }

}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    ELearningTheme {
        val navController = rememberNavController()
        MyAccountApp(navController
        )
    }
}