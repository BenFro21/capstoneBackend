package com.broad.parentPlanner.dtos;

import com.broad.parentPlanner.entities.Child;
import com.broad.parentPlanner.entities.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {


    private Long id;

    private String email;

    private String username;

    private String password;

    private Set<Child> childSet = new HashSet<>();

    public UserDto(User user) {
        if(user.getId() != null){
            this.id = user.getId();

        }
        if(user.getEmail() != null){
            this.email = user.getEmail();
        }
        if(user.getUsername() != null){
            this.username = user.getUsername();
        }
        if(user.getPassword() != null){
            this.password = user.getPassword();
        }
    }
}
