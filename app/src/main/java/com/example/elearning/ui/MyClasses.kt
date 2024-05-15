package com.example.elearning.ui

import android.annotation.SuppressLint
import android.health.connect.datatypes.units.Percentage
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.elearning.FooterComponent
import com.example.elearning.R
import com.example.elearning.ui.model.MyCourses

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyClassesApp(navController: NavController) {
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
                            text = "MY CLASSES",
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
                MyClasses()
            }
        },
        bottomBar = {
            FooterComponent(navController)
        }
    )
}


@Composable
fun MyClasses(){
    val mycourse1 = MyCourses(R.drawable.biology,"Biology","Science","60")
    val mycourse2 = MyCourses(R.drawable.physics,"Physics","Science","50")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp)
    ) {
        MyClass(mycourse1)
        MyClass(mycourse2)
    }
}

@Composable
fun MyClass(course:MyCourses){
    val completion = course.status.toFloat().coerceIn(0f, 100f) / 100f
    Card(
        modifier = Modifier.padding(12.dp),
        shape = RoundedCornerShape(0.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        content = {
            Row {
                Image(
                    painter = painterResource(course.imageResource),
                    contentDescription = "Physics",
                    modifier = Modifier
                        .size(100.dp),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(top=5.dp,start=8.dp)) {
                    Text(
                        text = course.description,
                        fontSize = 16.sp,
                        color = Color(0xFF874ECF),
                        modifier = Modifier.padding(top = 5.dp)
                    )
                    Text(
                        text = course.domain,
                        fontSize = 12.sp,
                        color = Color(0xFF874ECF),
                        modifier = Modifier.padding(top = 2.dp)
                    )
                    Text(
                        text = "${course.status}% Completed",
                        fontSize = 10.sp,
                        color = Color(0xFF874ECF),
                        modifier = Modifier.padding(top = 5.dp, bottom = 3.dp)
                    )
                    Surface(
                        color = Black,
                        shape = RoundedCornerShape(16.dp), // Set the corner radius here
                        modifier = Modifier
                            .height(4.dp)
                            .padding(top = 1.dp, end = 30.dp)
                    ) {
                        LinearProgressIndicator(
                            progress = completion,
                            color = Color(0xFF874ECF),
                            trackColor = Color(0xFFE1DFEC), // Set to transparent to hide the default background
                            modifier = Modifier.fillMaxSize() // Fill the size of the Surface
                        )
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MyClassesPreview(){
    val navController = rememberNavController()
    MyClassesApp(navController)
}