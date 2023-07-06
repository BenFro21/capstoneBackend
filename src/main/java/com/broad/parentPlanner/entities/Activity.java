package com.broad.parentPlanner.entities;

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
    private HashSet<String> kids;

    @Column
    private String description;

    @Column
    private Date startDate;

    @Column
    private boolean completed = false;


}
