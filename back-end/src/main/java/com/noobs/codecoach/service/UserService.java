package com.noobs.codecoach.service;

import com.noobs.codecoach.domain.entity.Role;
import com.noobs.codecoach.domain.entity.User;
import com.noobs.codecoach.domain.repository.UserRepository;
import com.noobs.codecoach.service.dto.request.CreateUserDTO;
import com.noobs.codecoach.service.dto.response.UserDTO;
import com.noobs.codecoach.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

//    public GetUserProfileDTO getUserById(int id) {
//        if (userRepository.getUserById(id) == null) {
//            throw new IllegalArgumentException("Id is invalid");
//        }
//        return userMapper.toGetUserProfileDTO(userRepository.getUserById(id));
//    }

    public UserDTO createUser(CreateUserDTO createUserDTO) {
        User user = userMapper.fromDto(createUserDTO);
        User createdUser = userRepository.save(user);
        return userMapper.toDto(createdUser);
    }

    public UserDTO getUserById(int id) {
        if (userRepository.getUserById(id) == null) {
            throw new IllegalArgumentException("Id is invalid");
        }
        return userMapper.toDto(userRepository.getUserById(id));
    }

    public void updateRoleToCoach(int id) {
        User user = userRepository.getUserById(id);
        user.setRole(Role.COACH.getRoleName());
        userRepository.save(user);
    }
}
