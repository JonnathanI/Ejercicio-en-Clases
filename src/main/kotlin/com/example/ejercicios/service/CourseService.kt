package com.example.ejercicios.service

import com.example.ejercicios.model.Course
import com.example.ejercicios.model.Student
import com.example.ejercicios.repository.CourseRepository
import com.example.ejercicios.repository.StudentRespository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CourseService {
    @Autowired
    lateinit var courseRepository: CourseRepository

    @Autowired
    lateinit var  studentRespository: StudentRespository

    fun list():List<Course>{
        return courseRepository.findAll()
    }

    fun save(course: Course):Course{
        try {
            studentRespository.findById(course.student_id)?: throw Exception("Id del Cliente no Encontrado")
            return courseRepository.save(course)
        }catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message,ex)
        }

    }

    fun update(course: Course):Course{
        try {


            courseRepository.findById(course.id) ?: throw Exception("Ya existe este ID")
            return courseRepository.save(course)
        }
        catch(ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(course: Course):Course{
        try {

            var response = courseRepository.findById(course.id) ?: throw Exception("Ya existe este ID")
            response.apply {
                name=course.name

            }
            return courseRepository.save(response)
        }
        catch(ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long){
        try {

            var response = courseRepository.findById(id).orElseThrow{throw ResponseStatusException(HttpStatus.NOT_FOUND, "Curso no Existe con el Id:  $id")}
                 courseRepository.delete(response)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el estudiante", ex)
        }
    }

}