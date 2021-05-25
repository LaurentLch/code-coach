package com.noobs.codecoach.service;

import com.noobs.codecoach.domain.entity.Role;
import com.noobs.codecoach.domain.entity.User;
import com.noobs.codecoach.domain.repository.UserRepository;
import com.noobs.codecoach.infrastructure.security.authentication.user.api.Account;
import com.noobs.codecoach.infrastructure.security.authentication.user.api.AccountService;
import com.noobs.codecoach.infrastructure.security.authentication.user.api.CreateSecuredUserDto;
import com.noobs.codecoach.service.dto.request.CreateSimpleUserDTO;
import com.noobs.codecoach.service.dto.response.SimpleUserDTO;
import com.noobs.codecoach.service.dto.response.UserDTO;
import com.noobs.codecoach.service.mapper.SimpleUserMapper;
import com.noobs.codecoach.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService implements AccountService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final SimpleUserMapper simpleUserMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, SimpleUserMapper simpleUserMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.simpleUserMapper = simpleUserMapper;
    }

    public SimpleUserDTO createSimpleUser(CreateSimpleUserDTO createSimpleUserDTO) {
        User user = simpleUserMapper.fromDto(createSimpleUserDTO);
        User createdUser = userRepository.save(user);
        return simpleUserMapper.toDto(createdUser);
    }

    public UserDTO getUserById(long id) {
        if (userRepository.getUserById(id) == null) {
            throw new IllegalArgumentException("Id is invalid");
        }
        return userMapper.toDto(userRepository.getUserById(id));
    }

    public void updateRoleToCoach(long id) {
        User user = userRepository.getUserById(id);
        user.setRole(Role.COACH.getRoleName());
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String userName) {
        return Optional.ofNullable(userRepository.getUserByEmail(userName));
    }

    @Override
    public Account createAccount(CreateSecuredUserDto createSecuredUserDto) {
        User user = userMapper.toAccount(createSecuredUserDto);
        return userRepository.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.getUserByEmail(email) != null;
    }
}
