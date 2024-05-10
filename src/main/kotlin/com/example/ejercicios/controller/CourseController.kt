package com.example.ejercicios.controller

import com.example.ejercicios.model.Course
import com.example.ejercicios.model.Student
import com.example.ejercicios.service.CourseService
import com.example.ejercicios.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/course")
class CourseController {
@Autowired
lateinit var courseService: CourseService

@GetMapping
fun list():List<Course>{
    return courseService.list()
}
    @PostMapping
    fun save(@RequestBody course: Course):Course{
        return courseService.save(course)
    }
    @PutMapping
    fun update(@RequestBody course: Course):ResponseEntity< Course>{
        return ResponseEntity( courseService.update(course), HttpStatus.OK)
    }
    @PatchMapping
    fun updateName(@RequestBody course: Course):ResponseEntity< Course>{
        return ResponseEntity( courseService.updateName(course), HttpStatus.OK)
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id:Long):ResponseEntity< String>{
        courseService.delete(id)
        return ResponseEntity("Curso Eliminado", HttpStatus.OK)
    }

}