package com.broad.parentPlanner.controllers;

import com.broad.parentPlanner.dtos.ActivityDto;
import com.broad.parentPlanner.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    // get all activitys by child
    @GetMapping("/child/{childId}")
    public List<ActivityDto> getActivityByChild(@PathVariable Long childId){
        return activityService.getAllActivityByChildId(childId);
    }

    // get an activity by id
    @GetMapping("/{activityId}")
    public Optional<ActivityDto> getActivityById(@PathVariable Long activityId){
        return activityService.getActivityById(activityId);
    }

    // add a new activity
    @PostMapping("/child/{childId}")
    public void addActivity(@RequestBody ActivityDto activityDto, @PathVariable Long childId){
        activityService.addActivity(activityDto, childId);
    }

    // delete an activity
    @DeleteMapping("/{activityId}")
    public void deleteActivityById(@PathVariable Long activityId){
        activityService.deleteActivityById(activityId);
    }

    // update existing activity
    @PutMapping("/{activityId}")
    public void updateActivity(@RequestBody ActivityDto activityDto){
        activityService.updateActivityById(activityDto);
    }


}
