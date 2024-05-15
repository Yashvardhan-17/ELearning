package com.example.elearning.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.elearning.FooterComponent
import com.example.elearning.R
import com.example.elearning.Title

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAccountApp(navController: NavController) {
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
                            text = "MY ACCOUNT",
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
                MyAccount(navController)
            }
        },
        bottomBar = {
            FooterComponent(navController)
        }
    )
}

@Composable
fun MyAccount(navController: NavController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 75.dp)
    ){
        PersonDetail()
        Details(description = "Account Settings")
        Details(description = "Download Options")
        Details(description = "Notifications Settings")
        Details(description = "Privacy & Policy")
        Details(description = "Help Center")
        Details(description = "About Us")
        Text(text = "Delete Account",
        fontSize = 18.sp,
        color = Color.Red,
        modifier = Modifier.padding(top=20.dp, start = 34.dp))

        Box(
            modifier = Modifier
                .padding(top = 55.dp, start = 72.dp)
                .fillMaxWidth()
            ) {
                Button(
                    onClick = {navController.navigate(Screen.introPage.route)},
                    colors = ButtonDefaults.buttonColors(Color(0xFF874ECF)),
                    modifier = Modifier
                        .width(250.dp)
                        .height(45.dp)
                ) {
                    Text(
                        text = "Log Out",
                        fontSize = 16.sp,
                        modifier = Modifier.background(Color(0xFF874ECF))
                    )
                }
        }
    }
}


@Composable
fun Details(description:String){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        verticalAlignment = CenterVertically,

    ){
        Text(text = description,
            fontSize = 18.sp,
            color = Color(0xFF874ECF),
            modifier = Modifier.padding(top=8.dp, start = 30.dp)
            )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /* Handle back action here */ }) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Back",
                tint = Color(0xFF874ECF),
                modifier = Modifier
                    .size(30.dp)
                    .padding(top = 8.dp)

            )
        }
    }
}
@Composable
fun PersonDetail(){
   Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color(0xFF874ECF)),
        content = {
            Row(
                verticalAlignment = CenterVertically,
                modifier = Modifier
                    .padding(20.dp)
            ) {

                Image(painter = painterResource(id = R.drawable.profile_pic),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape), // Apply circular clipping to the image
                    contentScale = ContentScale.Crop
                )

                Column (
                    modifier = Modifier
                        .padding(start=20.dp)
                ){
                    Text(text="John Doe",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold)
                    Text(text = "john@gamil.com",
                        color = Color.White,)
                }

            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun MyAccountPreview(){
    val navController = rememberNavController()
    MyAccountApp(navController = navController)
}