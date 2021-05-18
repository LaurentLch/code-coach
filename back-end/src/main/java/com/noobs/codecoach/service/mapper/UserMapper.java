package com.noobs.codecoach.service.mapper;

import com.noobs.codecoach.domain.entity.User;
import com.noobs.codecoach.domain.entity.Role;
import com.noobs.codecoach.service.dto.request.CreateUserDTO;
import com.noobs.codecoach.service.dto.response.GetUserProfileDTO;
import com.noobs.codecoach.service.dto.response.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User fromDto(CreateUserDTO createUserDTO) {
        return new User(
                createUserDTO.getFirstName(),
                createUserDTO.getLastName(),
                createUserDTO.getEmail(),
                createUserDTO.getPassword()
        );
    }

    public UserDTO toDto(User user) {
        return new UserDTO()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword());
    }

    public GetUserProfileDTO toGetUserProfileDTO(User user) {
        return new GetUserProfileDTO()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setRole(Role.COACHEE);  //<- to fis as enum
                //.setTrainingClass("None");  <-To fix as list
    }
}