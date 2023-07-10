package com.broad.parentPlanner.controllers;

import com.broad.parentPlanner.dtos.ChildDto;
import com.broad.parentPlanner.services.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/child")
public class ChildController {

    @Autowired
    private ChildService childService;

    //add new child
    @PostMapping("/user/{userId}")
    public void addChild(@RequestBody ChildDto childDto, @PathVariable Long userId){
        childService.addChild(childDto, userId);
    }

    // delete child by id
    @DeleteMapping("/{childId}")
    public void deleteChildById(@PathVariable Long childId){
        childService.deleteChildById(childId);
    }
}
