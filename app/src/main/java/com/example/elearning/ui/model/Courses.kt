package com.example.elearning.ui.model

import androidx.annotation.DrawableRes

data class Courses(
    val domain:String,
    @DrawableRes val imageResource:Int,
    val description:String,
    val duration:String,
    val coursesCount:String,
)

data class MyCourses(
    @DrawableRes val imageResource: Int,
    val description: String,
    val domain: String,
    val status:String
)
