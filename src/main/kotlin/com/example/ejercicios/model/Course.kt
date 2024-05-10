package com.example.ejercicios.model

import jakarta.persistence.*

@Entity
@Table(name = "cource")
class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long?= null
    var description: String?= null
    var name: String?= null
    var student_id: Long?= null
}