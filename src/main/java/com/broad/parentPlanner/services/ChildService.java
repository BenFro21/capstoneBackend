package com.broad.parentPlanner.services;

import com.broad.parentPlanner.dtos.ChildDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ChildService {
    @Transactional
    List<String> addChild(ChildDto childDto, Long userId);

    @Transactional
    void deleteChildById(Long childId);
}
