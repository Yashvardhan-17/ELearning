package com.example.elearning.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

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
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.elearning.R
import com.example.elearning.R.*
import com.example.elearning.Title

@Composable
fun levelIndicator(navController: NavController){

    val levels = listOf("Beginner", "Intermediate", "Expert")
    var confirm by remember {
        mutableStateOf(false)
    }
    val selectedLevel = remember { mutableStateOf<String?>(null) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(R.drawable.level_indicator_image) ,
            contentDescription = "sample learning image",
            modifier = Modifier
                .width(400.dp)
                .height(300.dp),
            contentScale = ContentScale.Fit
        )

        CourseLevelSelector(levels = levels,selectedLevel)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 35.dp)

        ) {
            Surface(
                color = Color.Transparent,
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        color = if (confirm) Color(0xFF874ECF) else Color.Transparent,
                    )
            ) {
                Checkbox(
                    checked = confirm,
                    onCheckedChange = { confirm = it },
                    modifier = Modifier.padding(4.dp)
                )
            }
            Text(text = "Are you sure?",
                color = Color(0xFF874ECF),
                modifier = Modifier.padding(start = 10.dp))
        }
        Box(
            modifier = Modifier
                .padding(top=20.dp)
        ) {
            Button(
                onClick = { if(confirm && selectedLevel.value!=null){navController.navigate(Screen.MyClasses.route)
                }},
                colors = ButtonDefaults.buttonColors(Color(0xFF874ECF)),
                modifier = Modifier
                    .width(250.dp)
                    .height(45.dp)


            ) {
                Text(
                    text = "Continue",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .background(Color(0xFF874ECF))
                )
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun levelIndicatorApp(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.weight(1f)) // Pushes the title to the center
                        Text(
                            text = "",
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            color = Color(0xFF874ECF),
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f)) // Pushes the title to the center
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowLeft,
                            contentDescription = "Back",
                            tint = Color(0xFF874ECF),
                            modifier = Modifier
                                .size(30.dp)
                                .padding(top = 8.dp)

                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.White)
            )
        },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Title()
                levelIndicator(navController)
            }
        }
    )
}

@Composable
fun CourseLevelSelector(levels: List<String>, selectedLevel: MutableState<String?>) {


    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Select Course Level",
            color = Color(0xFF874ECF),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, start = 10.dp, top = 10.dp)
        )
        Row{
        levels.forEach { level ->
            Surface(
                modifier = Modifier
                    .padding(
                        top = 25.dp,
                        start = 6.dp
                    )
                    .width(120.dp)
                    .height(25.dp)
                    .clickable { selectedLevel.value = level },
                color = if (level == selectedLevel.value) Color(0xFF874ECF) else Color.White,
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(width = 2.dp, color = Color(0xFF874ECF))
            ) {
                Text(
                    text = level,
                    textAlign = TextAlign.Center,
                    color = if(level==selectedLevel.value) Color.White else Color(0xFF874ECF),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)

                )
            }
        }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun levelIndicatorPreview(){
    val navController = rememberNavController()
    levelIndicatorApp(navController = navController)
}

