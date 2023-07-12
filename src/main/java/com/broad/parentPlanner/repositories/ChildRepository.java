package com.broad.parentPlanner.repositories;


import com.broad.parentPlanner.entities.Child;
import com.broad.parentPlanner.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {
    List<Child> findAllByUserEquals(User user);
}
