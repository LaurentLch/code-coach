package com.noobs.codecoach.service.mapper;

import com.noobs.codecoach.domain.entity.User;
import com.noobs.codecoach.service.dto.request.CreateSimpleUserDTO;
import com.noobs.codecoach.service.dto.response.SimpleUserDTO;
import org.springframework.stereotype.Component;

@Component
public class SimpleUserMapper {

    public User fromDto(CreateSimpleUserDTO createSimpleUserDTO) {
        return new User(
                createSimpleUserDTO.getFirstName(),
                createSimpleUserDTO.getLastName(),
                createSimpleUserDTO.getEmail(),
                createSimpleUserDTO.getPassword()
        );
    }

    public SimpleUserDTO toDto(User user) {
        return new SimpleUserDTO()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .setRole(user.getRole());
    }
}
