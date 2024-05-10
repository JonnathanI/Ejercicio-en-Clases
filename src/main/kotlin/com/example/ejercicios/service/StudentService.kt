package com.example.ejercicios.service

import com.example.ejercicios.model.Student
import com.example.ejercicios.repository.StudentRespository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class StudentService {
    @Autowired
    lateinit var studentRespository: StudentRespository

    fun list():List<Student>{
        return studentRespository.findAll()
    }

    fun save(student:Student):Student{
        return studentRespository.save(student)
    }

    fun update(student:Student):Student{
        try {


            studentRespository.findById(student.id) ?: throw Exception("Ya existe este ID")
            return studentRespository.save(student)
        }
        catch(ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(student:Student):Student{
        try {

            var response = studentRespository.findById(student.id) ?: throw Exception("Ya existe este ID")
            response.apply {
                fullname=student.fullname

            }
            return studentRespository.save(response)
        }
        catch(ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun delete(id: Long){
        try {

            var response = studentRespository.findById(id).orElseThrow{throw ResponseStatusException(HttpStatus.NOT_FOUND, "Estudiante no Existe con el Id:  $id")}
                 studentRespository.delete(response)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al eliminar el estudiante", ex)
        }
    }

}