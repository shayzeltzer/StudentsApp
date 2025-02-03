package com.example.studentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val nameField = findViewById<EditText>(R.id.editTextName)
        val idField = findViewById<EditText>(R.id.editTextId)
        val addButton = findViewById<Button>(R.id.buttonAddStudent)

        addButton.setOnClickListener {
            val name = nameField.text.toString()
            val id = idField.text.toString()

            if (name.isNotEmpty() && id.isNotEmpty()) {
                StudentRepository.addStudent(Student(id, name, false, R.drawable.default_profile))
                finish()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
