package com.nebrija.app.student.domain.repository

import com.nebrija.app.student.infrastructure.entity.StudentEntity

interface IStudentRepository {
    fun createStudent(student: StudentEntity);

    fun getStudentByUUID(studentUUID: String): StudentEntity?;

    fun updateStudent(student: StudentEntity);

    fun deleteStudent(student: StudentEntity);
}