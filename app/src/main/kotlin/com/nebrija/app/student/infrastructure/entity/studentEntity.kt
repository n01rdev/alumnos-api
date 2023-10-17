package com.nebrija.app.student.infrastructure.entity

import jakarta.persistence.*
import org.hibernate.annotations.UuidGenerator

@Entity
@Table(name = "student")
class studentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0;

    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    var uuid: String = "";

    var firstName: String = "";

    var lastName: String = "";

    var grade: String = "";

    var group: String = "";
}