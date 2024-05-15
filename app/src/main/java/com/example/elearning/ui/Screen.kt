package com.example.elearning.ui

sealed class Screen(val route:String){
    object introPage : Screen(route = "introPage_Screen")
    object LoginPage:Screen(route = "loginPage_Screen")
    object levelIndicator:Screen(route = "LevelIndicator_Page")
    object HomePage:Screen(route="HomePage_Screen")
    object Classes:Screen(route = "Classes_Screen")
    object MyClasses:Screen(route = "MyClasses_Screen")
    object MyAccount:Screen(route = "MyAccount_Screen")
}
