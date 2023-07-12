package com.broad.parentPlanner.services;

import com.broad.parentPlanner.dtos.ChildDto;
import com.broad.parentPlanner.entities.Child;
import com.broad.parentPlanner.entities.User;
import com.broad.parentPlanner.repositories.ChildRepository;
import com.broad.parentPlanner.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    @Transactional
    public List<String> addChild(ChildDto childDto, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        List<String> response = new ArrayList<>();
        Child child = new Child(childDto);
        userOptional.ifPresent(child::setUser);
        childRepository.saveAndFlush(child);
        return response;
    }

    @Override
    @Transactional
    public void deleteChildById(Long childId){
        Optional<Child> childOptional = childRepository.findById(childId);
        childOptional.ifPresent(child -> childRepository.delete(child));
    }

    @Override
    @Transactional
    public List<ChildDto> getAllChildByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            List<Child> childList = childRepository.findAllByUserEquals(userOptional.get());
            return childList.stream().map(child -> new ChildDto(child)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }


}

