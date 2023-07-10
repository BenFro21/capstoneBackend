package com.broad.parentPlanner.services;

import com.broad.parentPlanner.dtos.ActivityDto;
import com.broad.parentPlanner.entities.Activity;
import com.broad.parentPlanner.entities.Child;
import com.broad.parentPlanner.repositories.ActivityRepository;
import com.broad.parentPlanner.repositories.ChildRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private ActivityRepository activityRepository;

    // adding activity
    @Override
    @Transactional
    public void addActivity(ActivityDto activityDto, Long childId){
        Optional<Child> childOptional = childRepository.findById(childId);
        Activity activity = new Activity(activityDto);
        childOptional.ifPresent(activity:: setChild);
        activityRepository.saveAndFlush(activity);
    }

    // Deleteing Activity
    @Override
    @Transactional
    public void deleteActivityById(Long activityId){
        Optional<Activity> activityOptional = activityRepository.findById(activityId);
        activityOptional.ifPresent(activity -> activityRepository.delete(activity));
    }

    //updateing Activity
    @Override
    @Transactional
    public void updateActivityById(ActivityDto activityDto){
        Optional<Activity> activityOptional = activityRepository.findById(activityDto.getId());
        activityOptional.ifPresent(activity -> {
            activity.setTitle(activityDto.getTitle());
            activity.setDescription(activityDto.getDescription());
            activity.setStartDate(activityDto.getStartDate());
            activityRepository.saveAndFlush(activity);
        });
    }

    //get all activites by childId
    @Override
    public List<ActivityDto> getAllActivityByChildId(Long childId){
        Optional<Child> childOptional = childRepository.findById(childId);
        if(childOptional.isPresent()){
            List<Activity> activityList = activityRepository.findAllByChildEquals(childOptional.get());
            return activityList.stream().map(activity -> new ActivityDto(activity)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    // get a activity by id
    @Override
    public Optional<ActivityDto> getActivityById(Long activityId){
        Optional<Activity> activityOptional = activityRepository.findById(activityId);
        if(activityOptional.isPresent()){
            return Optional.of(new ActivityDto(activityOptional.get()));
        }
        return Optional.empty();
    }
}
