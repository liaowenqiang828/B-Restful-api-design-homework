package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private GroupRepository groupRepository;
    private StudentRepository studentRepository;
    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public ResponseEntity<List<Group>> getGroupList() {
        if (groupRepository.findAll().size() == 0) {
            groupRepository.divideGroupRandomly(studentRepository.findAll());
        }
        return ResponseEntity.ok(groupRepository.findAll());
    }

    public void updateGroupName(int id, Group group) {
        Group groupTemp = groupRepository.findById(id);
        if (null != group.getName() && !group.getName().equals(groupTemp.getName())) {
            groupTemp.setName(group.getName());
        }
    }
}
