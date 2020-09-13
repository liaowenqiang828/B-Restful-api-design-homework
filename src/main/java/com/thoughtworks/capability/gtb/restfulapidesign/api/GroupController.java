package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    private GroupService groupService;
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> getGroupList() {
        return this.groupService.getGroupList();
    }

    @PatchMapping("/groups/{id}")
    public void updateGroupName(@PathVariable("id") int id, @RequestBody Group group) {
        this.groupService.updateGroupName(id, group);
    }

}
