package com.example.ejercicios.controller

import com.example.ejercicios.model.Student
import com.example.ejercicios.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
class StudentController {
@Autowired
lateinit var studentService: StudentService

@GetMapping
fun list():List<Student>{
    return studentService.list()
}
    @PostMapping
    fun save(@RequestBody student: Student):Student{
        return studentService.save(student)
    }
    @PutMapping
    fun update(@RequestBody student: Student):ResponseEntity< Student>{
        return ResponseEntity( studentService.update(student), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName(@RequestBody student: Student):ResponseEntity< Student>{
        return ResponseEntity( studentService.updateName(student), HttpStatus.OK)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity< String>{
        studentService.delete(id)
        return ResponseEntity("Estudiante Eliminado", HttpStatus.OK)
    }

}