package com.noobs.codecoach.service.mapper;

import com.noobs.codecoach.domain.entity.User;
import com.noobs.codecoach.service.dto.request.CreateUserDTO;
import com.noobs.codecoach.service.dto.response.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final CoachInfoMapper coachInfoMapper;

    @Autowired
    public UserMapper(CoachInfoMapper coachInfoMapper) {
        this.coachInfoMapper = coachInfoMapper;
    }

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
                .setPassword(user.getPassword())
                .setRole(user.getRole())
                .setCoachInfoDTO(user.getCoachInfo() != null ? coachInfoMapper.toDto(user.getCoachInfo()) : null);
        //.setTrainingClass("None");  <-To fix as list
    }
}
