package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        studentRepository.save(new Student(1, "小王", "男", "喜欢唱歌"));
        studentRepository.save(new Student(2, "小赵", "男", "喜欢跳舞"));
        studentRepository.save(new Student(3, "小钱", "男", "喜欢Rap"));
        studentRepository.save(new Student(4, "小孙", "男", "喜欢篮球"));
        studentRepository.save(new Student(5, "小李", "男", "喜欢唱歌"));
        studentRepository.save(new Student(6, "小周", "男", "喜欢跳舞"));
        studentRepository.save(new Student(7, "小吴", "男", "喜欢Rap"));
        studentRepository.save(new Student(8, "小郑", "男", "喜欢篮球"));
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}
