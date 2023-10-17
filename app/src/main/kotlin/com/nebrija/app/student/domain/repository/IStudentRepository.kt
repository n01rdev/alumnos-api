package com.nebrija.app.student.domain.repository

interface IStudentRepository {
    public fun createStudent();

    public fun getStudent();

    public fun updateStudent();

    public fun deleteStudent();
}