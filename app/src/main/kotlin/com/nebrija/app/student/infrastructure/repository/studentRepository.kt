package com.nebrija.app.student.infrastructure.repository

import com.nebrija.app.student.domain.repository.IStudentRepository
import org.springframework.stereotype.Repository

@Repository
class studentRepository :IStudentRepository{

    override fun createStudent() {
        println("Creating student")
    }

    override fun getStudent() {
        println("Getting student")
    }

    override fun updateStudent() {
        println("Updating student")
    }

    override fun deleteStudent() {
        println("Deleting student")
    }
}