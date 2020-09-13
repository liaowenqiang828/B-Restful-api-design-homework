package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(
            @RequestParam(value = "gender", required = false)
            String gender
            ) {
        return studentService.getAllStudents(gender);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudentById(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }
}
