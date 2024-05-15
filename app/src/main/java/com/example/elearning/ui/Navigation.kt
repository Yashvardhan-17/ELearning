package com.example.elearning.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.savedstate.SavedStateRegistryController

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
   NavHost(
       navController = navController,
       startDestination = Screen.introPage.route
   ){
       composable(route=Screen.introPage.route){
           introPage(navController)
       }
       composable(route=Screen.HomePage.route){
           HomeApp(navController)
       }
       composable(route=Screen.Classes.route){
           BookClassesApp(navController)
       }
       composable(route=Screen.MyClasses.route){
           MyClassesApp(navController)
       }
       composable(route=Screen.levelIndicator.route){
           levelIndicatorApp(navController)
       }
       composable(route=Screen.MyAccount.route){
           MyAccountApp(navController)
       }
       composable(route=Screen.LoginPage.route){
           loginPageApp(navController)
       }

   }

}