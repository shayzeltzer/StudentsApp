package com.example.studentsapp

data class Student(
    var id: String,
    var name: String,
    var isChecked: Boolean,
    val profilePicture: Int // Reference to drawable resource
)
