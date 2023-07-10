package com.broad.parentPlanner.services;

import com.broad.parentPlanner.dtos.ActivityDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    // adding activity
    @Transactional
    void addActivity(ActivityDto activityDto, Long childId);

    // Deleteing Activity
    @Transactional
    void deleteActivityById(Long activityId);

    //updateing Activity
    @Transactional
    void updateActivityById(ActivityDto activityDto);

    //get all activites by childId
    List<ActivityDto> getAllActivityByChildId(Long childId);

    // get a activity by id
    Optional<ActivityDto> getActivityById(Long activityId);
}
