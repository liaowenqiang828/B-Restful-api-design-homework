package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository {
    void divideGroupRandomly(List<Student> studentList);

    List<Group> findAll();

    Group findById(int id);
}
