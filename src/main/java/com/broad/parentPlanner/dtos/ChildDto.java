package com.broad.parentPlanner.dtos;

import com.broad.parentPlanner.entities.Activity;
import com.broad.parentPlanner.entities.Child;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildDto implements Serializable {

    private Long id;

    private String name;

    private UserDto userDto;

    private Set<Activity> activitySet = new HashSet<>();

    public ChildDto(Child child) {
        if(child.getId() != null){
            this.id = child.getId();
        }
        if(child.getName() != null){
            this.name = child.getName();
        }
    }


}
