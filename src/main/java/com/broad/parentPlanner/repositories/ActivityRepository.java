package com.broad.parentPlanner.repositories;


import com.broad.parentPlanner.entities.Activity;
import com.broad.parentPlanner.entities.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByChildEquals(Child child);
}
