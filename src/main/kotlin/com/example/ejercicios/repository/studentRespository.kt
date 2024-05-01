package com.example.ejercicios.repository

import com.example.ejercicios.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRespository:JpaRepository<Student, Long>{
    fun  findById(id: Long?): Student?
}