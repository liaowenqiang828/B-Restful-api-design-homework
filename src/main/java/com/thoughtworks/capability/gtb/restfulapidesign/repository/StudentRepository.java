package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository {
    Student save(Student student);
    List<Student> findAll();
    Student findById(int id);
    void deleteById(int id);
    void deleteByName(String name);
}
