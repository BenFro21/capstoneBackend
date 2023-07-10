package com.broad.parentPlanner.services;

import com.broad.parentPlanner.dtos.UserDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    List<String> addUser(UserDto userDto);

    // doing email instead of username
    List<String> userLogin(UserDto userDto);
}
