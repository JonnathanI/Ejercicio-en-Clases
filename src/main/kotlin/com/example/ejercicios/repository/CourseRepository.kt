package com.example.ejercicios.repository

import com.example.ejercicios.model.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : JpaRepository<Course,Long>{
    fun  findById(id: Long?): Course?
}