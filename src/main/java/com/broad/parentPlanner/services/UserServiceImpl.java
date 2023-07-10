package com.broad.parentPlanner.services;

import com.broad.parentPlanner.dtos.UserDto;
import com.broad.parentPlanner.entities.User;
import com.broad.parentPlanner.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addUser(UserDto userDto){
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
        userRepository.saveAndFlush(user);
        response.add("User Added scuccessfully");
        return response;
    }

    // doing email instead of username
    @Override
    public List<String> userLogin(UserDto userDto) {
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByEmail(userDto.getEmail());
        if (userOptional.isPresent()) {
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())) {
                response.add("User login successful");
                response.add(String.valueOf(userOptional.get().getId()));
            } else {
                response.add("Email or password incorrect");
            }
        }else{
            response.add("Username or Password incorrect");
    }
        return response;
    }
}
