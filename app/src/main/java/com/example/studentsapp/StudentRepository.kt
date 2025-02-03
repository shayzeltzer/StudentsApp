package com.example.studentsapp

object StudentRepository {
    private val students = mutableListOf<Student>()

    fun getAllStudents() = students

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun updateStudent(student: Student) {
        val index = students.indexOfFirst { it.id == student.id }
        if (index != -1) students[index] = student
    }

    fun deleteStudent(id: String) {
        students.removeIf { it.id == id }
    }

    fun getStudentById(id: String): Student? {
        return students.find { it.id == id }
    }
}
