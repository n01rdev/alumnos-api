package com.nebrija.app.student.infrastructure.entity

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator
import org.jetbrains.annotations.NotNull

@Entity
@Table(name = "student")
class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0;

    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    var uuid: String = "";

    @NotNull
    var firstName: String = "";

    @NotNull
    var lastName: String = "";

    @NotNull
    var grade: String = "";

    @NotNull
    var group: String = "";
}