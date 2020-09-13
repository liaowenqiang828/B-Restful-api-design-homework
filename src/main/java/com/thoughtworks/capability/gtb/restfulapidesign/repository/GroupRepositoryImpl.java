package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class GroupRepositoryImpl implements GroupRepository {
    private List<Group> groupList = new ArrayList<>();

    @Override
    public void divideGroupRandomly(List<Student> studentList) {
        int totalGroupNum = 6;
        int remainder = studentList.size() % totalGroupNum;
        int avgStudentNum = studentList.size() / totalGroupNum;
        int startIndex = 0;
        Collections.shuffle(studentList);

        if (avgStudentNum == 0) {
            dividerStudentWhenStudentNumberLessOrEqualThanTotalTeamNum(studentList, remainder);
        } else {
            dividerStudentWhenStudentNumberMoreThanTotalGroupNum(remainder, totalGroupNum, startIndex, studentList, avgStudentNum);
        }
    }

    @Override
    public List<Group> findAll() {

        return groupList;
    }

    private void dividerStudentWhenStudentNumberLessOrEqualThanTotalTeamNum(List<Student> studentList, int remainder) {
        for (int index = 0; index < remainder; index++) {
            groupList.add(Group.builder()
                    .id(index + 1)
                    .name("Team " + (index + 1))
                    .note("菜到家了")
                    .students(new ArrayList<>(Collections.singletonList(studentList.get(index))))
                    .build());
        }
    }

    private void dividerStudentWhenStudentNumberMoreThanTotalGroupNum(
            int remainder, int totalGroupNum, int startIndex,
            List<Student> studentList, int avgStudentNum) {
        int endIndex;
        for (int index = 0; index < totalGroupNum; index++) {
            if (remainder > 0 ) {
                endIndex = startIndex + avgStudentNum + 1;
                groupList.add(Group.builder()
                        .id(index + 1)
                        .name("Team " + (index + 1))
                        .note("菜到家了")
                        .students(new ArrayList<>(studentList.subList(startIndex, endIndex)))
                        .build());
                remainder -= 1;
                startIndex = endIndex;
            } else {
                endIndex = startIndex + avgStudentNum;
                groupList.add(Group.builder()
                        .id(index + 1)
                        .name("Team " + (index + 1))
                        .note("菜到家了")
                        .students(new ArrayList<>(studentList.subList(startIndex, endIndex)))
                        .build());
                startIndex = endIndex;
            }
        }
    }
}
