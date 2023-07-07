package com.broad.parentPlanner.entities;

import com.broad.parentPlanner.dtos.ChildDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Children")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

  @OneToMany(mappedBy = "child", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JsonManagedReference
  private Set<Activity> activitySet = new HashSet<>();

    @ManyToOne
    @JsonBackReference
    private User user;

    public Child(ChildDto childDto){
        if(childDto.getName() != null){
            this.name = childDto.getName();
        }
    }
}
