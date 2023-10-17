package com.nebrija.app.student.infrastructure.repository

import com.nebrija.app.student.domain.repository.IStudentRepository
import com.nebrija.app.student.infrastructure.entity.StudentEntity
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository

@Repository
class StudentRepository(private val entityManager: EntityManager) : IStudentRepository {
    override fun createStudent(student: StudentEntity) {
        entityManager.persist(student)
    }

    override fun getStudentByUUID(studentUUID: String): StudentEntity? {
        return entityManager.find(StudentEntity::class.java, studentUUID)
    }

    override fun updateStudent(student: StudentEntity) {
        entityManager.merge(student)
    }

    override fun deleteStudent(student: StudentEntity) {
        entityManager.remove(student)
    }
}