package com.example.elearning.ui

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.elearning.FooterComponent
import com.example.elearning.Title
import com.example.elearning.ui.Data.Datasource
import com.example.elearning.ui.model.Courses
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeApp(navController: NavController) {
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
                            text = "HOME",
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
                    IconButton(onClick = {navController.popBackStack()}) {
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
                Home(navController)
            }
        },
        bottomBar = {
            FooterComponent(navController)
        }
    )
}



@Composable
fun Home(navController: NavController){
    val name:String = "John Doe"
    val courses = Datasource().loadCourses()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ){
        Text(text = "Welcome Back",
            color = Color(0xFF874ECF),
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top=8.dp,start = 10.dp),
            fontFamily = FontFamily.SansSerif
        )
        Text(text = name,
            color = Color(0xFF874ECF),
            fontSize = 32.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top=8.dp, start = 10.dp),
            fontFamily = FontFamily.SansSerif
        )
        Row {
            Buttons(about = "Book Class", onClick = {navController.navigate(Screen.Classes.route)})
            Buttons(about = "My Course", onClick = {navController.navigate(Screen.MyClasses.route)})
        }
        Text(text = "Last Classes",
                fontSize = 25.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF874ECF),
                modifier = Modifier
                    .padding(top=40.dp, start = 20.dp)
        )
        LazyRow{
                items(courses){topic->
                    Course(topic = topic,navController)
                }
        }
    }
}

@Composable
fun Course(topic: Courses,navController: NavController){
    Card (
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier
            .width(270.dp)
            .padding(top = 30.dp, start = 10.dp)
            .clickable{navController.navigate(Screen.levelIndicator.route)},
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )


    ){
        Column (
            modifier = Modifier
                .fillMaxWidth()

        ){
            Image(
                painter = painterResource(topic.imageResource), contentDescription = topic.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),

                contentScale = ContentScale.Crop
            )
            Text(text = topic.domain,
                color = Color(0xFF874ECF),
                modifier = Modifier.padding(start = 15.dp,top=4.dp),
                fontSize = 18.sp
            )
            Text(text = topic.description,
                color = Color(0xFF874ECF),
                modifier = Modifier.padding(start=50.dp,top=8.dp),
                fontSize = 25.sp
                )
            Text(text = topic.duration,
                color = Color(0xFF874ECF),
                modifier = Modifier.padding(top=5.dp, start = 15.dp, bottom = 10.dp),
                fontSize = 16.sp)
        }
    }
}


@Composable
fun Buttons(about:String,onClick:()->Unit){

    Box(
        modifier = Modifier
            .padding(top=30.dp, start = 15.dp)
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(Color(0xFF874ECF)),
            modifier = Modifier
                .width(130.dp)
                .height(48.dp),
            shape = MaterialTheme.shapes.medium


        ) {
            Text(
                text = about,
                fontSize = 16.sp,
                modifier = Modifier
                    .background(Color(0xFF874ECF))
            )
        }
    }


}
@Preview(showBackground = true)
@Composable
fun HomePreview(){
    val navcontroller = rememberNavController()
    HomeApp(navcontroller)
}

