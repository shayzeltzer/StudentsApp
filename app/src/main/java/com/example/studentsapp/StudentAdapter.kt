package com.example.studentsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
    private val students: List<Student>,
    private val onRowClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.textViewName)
        val id: TextView = view.findViewById(R.id.textViewId)
        val image: ImageView = view.findViewById(R.id.imageViewProfile)
        val checkbox: CheckBox = view.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_row, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.name.text = student.name
        holder.id.text = student.id
        holder.image.setImageResource(student.profilePicture)
        holder.checkbox.isChecked = student.isChecked

        holder.checkbox.setOnCheckedChangeListener { _, isChecked ->
            student.isChecked = isChecked
        }

        holder.itemView.setOnClickListener { onRowClick(student) }
    }

    override fun getItemCount() = students.size
}
