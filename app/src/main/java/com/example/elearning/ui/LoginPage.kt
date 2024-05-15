package com.example.elearning.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.KeyboardArrowLeft


import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.elearning.Title


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loginPageApp(navController: NavController) {
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
                            text = "LOG IN",
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
                Title()
                loginPage(navController)
            }
        }
    )
}


    @Composable
    fun loginPage(navController: NavController){

        var email by remember{ mutableStateOf("") }
        var password by remember { mutableStateOf("")}
        val checkedState = remember {mutableStateOf(false)}

        Column (
           horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
        ){
            Text(
                text = "Enter Your log in details to access your account",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF874ECF),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 10.dp)
            )
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            ){
                FacebookButton {}
                GoogleButton {}
            }

            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label= {Text("Email")},
                modifier = Modifier
                    .padding(top=30.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                label= {Text("password")},
                modifier = Modifier
                    .padding(top=30.dp)

            )

            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                         .fillMaxWidth()
            ){
               SimpleCheckBox(checkedState)
                Text(text = "Forget Password?",
                    color = Color.Red,
                    modifier = Modifier
                        .padding(top=20.dp, start = 40.dp)
                )
            }
            Box(
                modifier = Modifier
                    .padding(top=20.dp)
            ) {
                Button(
                    onClick = {if(email.isNotEmpty() && checkedState.value){
                        navController.navigate(Screen.HomePage.route)
                    } },
                    colors = ButtonDefaults.buttonColors(Color(0xFF874ECF)),
                    modifier = Modifier
                        .width(250.dp)
                        .height(45.dp)


                ) {
                    Text(
                        text = "Log in with your account",
                        fontSize = 16.sp,
                        modifier = Modifier
                            .background(Color(0xFF874ECF))
                    )
                }
            }
            Row (
                modifier = Modifier
                    .padding(top=50.dp)
            ){
                Text(text = "Dont have an Account?",
                    color = Color(0xFF874ECF),
                    fontSize = 14.sp
                )
                Text(text = "Create account",
                    color = Color.Blue,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start=8.dp)
                    )


            }

        }

    }


    @Composable
    fun SimpleCheckBox(checkedState:MutableState<Boolean>){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top=20.dp, start = 30.dp)
        ){
            Checkbox(checked = checkedState.value,
                onCheckedChange = {checkedState.value=it})
            Text(text = "Remember Me?",
                color = Color( 0xFF874ECF),
                fontWeight = FontWeight.Medium
            )
        }
    }

@Composable
fun FacebookButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color.Blue),
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Filled.Facebook, contentDescription = "Facebook", tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Facebook", color = Color.White)
        }
    }
}
@Composable
fun GoogleButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color.Red),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(start=16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            GoogleIcon()
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Google", color = Color.White)
        }
    }
}

@Composable
fun GoogleIcon() {
    Box(
        modifier = Modifier.size(25.dp), // Set the size of the icon
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "G+", // Display the letter "G"
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White) // Customize the appearance of the letter
        )
    }
}
@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun loginPagePreview(){
    val navController = rememberNavController()
    loginPageApp(navController)
}