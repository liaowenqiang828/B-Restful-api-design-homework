package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final List<Student> studentList = new ArrayList<>();

    @Override
    public Student save(Student student) {
        studentList.add(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public Student findById(int id) {
        return studentList.get(id - 1);
    }

    @Override
    public void deleteById(int id) {
        studentList.remove(id - 1);
    }

    @Override
    public void deleteByName(String name){
        List<Student> studentRemoved = studentList.stream().filter(student ->
                student.getName().equals(name)).collect(Collectors.toList());
    }
}
