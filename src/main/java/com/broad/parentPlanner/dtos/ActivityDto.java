package com.broad.parentPlanner.dtos;

import com.broad.parentPlanner.entities.Activity;
import com.broad.parentPlanner.entities.Child;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto implements Serializable {

    private Long id;

    private String title;

    private String description;

    private String startDate;

    private boolean completed = false;

    private ChildDto childDto;

    public ActivityDto(Activity activity){
        if(activity.getId() != null) {
            this.id = activity.getId();
        }
        if(activity.getTitle() != null) {
            this.title = activity.getTitle();
        }
        if(activity.getDescription() != null) {
            this.description = activity.getDescription();
        }
        if(activity.getStartDate() != null) {
            this.startDate = activity.getStartDate();
        }
        if(activity.isCompleted()) {
            this.completed = activity.isCompleted();
        }
    }
}
