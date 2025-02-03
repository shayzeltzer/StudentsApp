package com.example.studentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val studentId = intent.getStringExtra("STUDENT_ID") ?: return
        val student = StudentRepository.getStudentById(studentId) ?: return

        val nameField = findViewById<EditText>(R.id.editTextName)
        val idField = findViewById<EditText>(R.id.editTextId)

        nameField.setText(student.name)
        idField.setText(student.id)

        findViewById<Button>(R.id.buttonUpdateStudent).setOnClickListener {
            student.name = nameField.text.toString()
            student.id = idField.text.toString()
            StudentRepository.updateStudent(student)
            finish()
        }

        findViewById<Button>(R.id.buttonDeleteStudent).setOnClickListener {
            StudentRepository.deleteStudent(student.id)
            finish()
        }
    }
}
