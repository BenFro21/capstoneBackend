package com.broad.parentPlanner.entities;

import com.broad.parentPlanner.dtos.ActivityDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;

@Entity
@Table(name = "Activity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Date startDate;

    @Column
    private boolean completed = false;

    @ManyToOne
    @JsonBackReference
    private Child child;

    public Activity(ActivityDto activityDto){
        if(activityDto.getTitle() != null){
            this.title = activityDto.getTitle();
        }
        if(activityDto.getDescription() != null){
            this.description = activityDto.getDescription();
        }
        if(activityDto.getStartDate() != null){
            this.startDate = activityDto.getStartDate();
        }
    }


}
