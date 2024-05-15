package com.example.elearning.ui.Data

import com.example.elearning.R
import com.example.elearning.ui.model.Courses

class Datasource {
    fun loadCourses():List<Courses>{
        return listOf<Courses>(
            Courses("Science",R.drawable.physics,"Physics","7h 2m","6 Courses"),
            Courses("Science",R.drawable.chemistry,"Chemistry","6h 5m","7 Courses"),
            Courses("Science",R.drawable.mathematics,"Mathematics","8h 3m","10 Courses"),
            Courses("Science",R.drawable.biology,"Biology","9h 0m","9 Courses")

        )
    }
}