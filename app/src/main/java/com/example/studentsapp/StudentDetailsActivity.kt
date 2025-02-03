package com.example.studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StudentDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val studentId = intent.getStringExtra("STUDENT_ID") ?: return
        val student = StudentRepository.getStudentById(studentId) ?: return

        findViewById<TextView>(R.id.textViewName).text = student.name
        findViewById<TextView>(R.id.textViewId).text = student.id
        findViewById<ImageView>(R.id.imageViewProfile).setImageResource(student.profilePicture)

        findViewById<Button>(R.id.buttonEditStudent).setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("STUDENT_ID", student.id)
            startActivity(intent)
            finish()
        }
    }
}
