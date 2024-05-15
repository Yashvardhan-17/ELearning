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
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import com.example.elearning.FooterComponent
import com.example.elearning.ui.Data.Datasource
import com.example.elearning.ui.model.Courses


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookClassesApp(navController: NavController) {
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
                            text = "BOOK YOUR CLASSES",
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
                BookClasses(navController)
            }
        },
        bottomBar = {
            FooterComponent(navController)
        }
    )
}


@Composable
fun BookClasses(navController: NavController){
    val courses = Datasource().loadCourses()
    var confirm by remember {
        mutableStateOf(false)
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow {
            items(courses) { topic ->
                Classes(topic = topic)
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            DropdownExample("Arts & Commerce")
            DropdownExample("Group Study")


        }

        LazyRow {
            items(courses) { topic ->
                Classes(topic = topic)
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 50.dp)

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
            Text(
                text = "Are you sure with the Selected Course?",
                color = Color(0xFF874ECF),
                modifier = Modifier.padding(start = 10.dp),
                fontSize = 15.sp
            )
        }
        Box(
            modifier = Modifier
                .padding(top=20.dp)
        ) {
            Button(
                onClick = { if(confirm){
                    navController.navigate(Screen.levelIndicator.route)
                } },
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
@Composable
fun DropdownExample(Option:String) {
    // Create state to manage the visibility of the dropdown menu
    val expanded = remember { mutableStateOf(false) }
    // Create state to hold the selected item
    val selectedItem = remember { mutableStateOf(Option) }

    // Dropdown menu content
    val dropdownItems = listOf("Option 1", "Option 2", "Option 3")

    Column(
        verticalArrangement = Arrangement.Top,

        modifier = Modifier
            .padding(top=10.dp, start = 15.dp)
    ) {
        // Dropdown button
        Text("Select Type",
            color = Color(0xFF874ECF),
            fontSize = 15.sp,
            modifier = Modifier.padding(bottom=4.dp)
        )
        Box(
            modifier = Modifier
                .clickable { expanded.value = true }
                .background(Color(0xFF874ECF))
                .padding(8.dp)
                .width(120.dp)
                .height(17.dp)
        ) {
            Text(text = selectedItem.value, fontSize = 12.sp, color = Color.White)
            // Dropdown icon
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = "Dropdown",
                modifier = Modifier.align(Alignment.CenterEnd),
                tint = Color.White
            )
        }

        // Dropdown menu
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier
                .width(100.dp)
        ) {
            dropdownItems.forEach { item ->
               DropdownMenuItem(text = { Text(text = item)} , onClick = {
                   selectedItem.value = item
                   expanded.value=false
               })
            }
        }
    }
}

@Composable
fun Classes(topic: Courses){
    var isClicked by remember { mutableStateOf(false) }
    Card (
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier
            .width(200.dp)
            .padding(top = 30.dp, start = 10.dp)
            .clickable { isClicked = !isClicked },
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isClicked) Color(0xFF874ECF) else Color.White
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
                    .height(100.dp),

                contentScale = ContentScale.Crop
            )
            Text(text = topic.description,
                color = if(isClicked) Color.White else Color(0xFF874ECF),
                modifier = Modifier.padding(start=20.dp,top=8.dp),
                fontSize = 25.sp
            )
            Text(text = topic.coursesCount,
                color = if(isClicked) Color.White else Color(0xFF874ECF),
                modifier = Modifier.padding(top=5.dp, start = 15.dp, bottom = 10.dp),
                fontSize = 16.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BookClassesPreview(){
    val navController = rememberNavController()
    BookClassesApp(navController)
}