package com.noobs.codecoach.service;

import com.noobs.codecoach.domain.entity.User;
import com.noobs.codecoach.domain.repository.UserRepository;
import com.noobs.codecoach.service.dto.response.UserDTO;
import com.noobs.codecoach.service.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    public UserMapper mapper;
    @Mock
    public UserRepository repository;
    @InjectMocks
    public UserService service;

    @Test
    void createUser_givenCreateUserDto_thenUsesMapperAndRepository() {
        //GIVEN
        when(mapper.fromDto(any())).thenReturn(new User());
        when(repository.save(any())).thenReturn(new User());
        when(mapper.toDto(any())).thenReturn(new UserDTO());
        //WHEN
        service.createSimpleUser(any());
        //THEN
        InOrder inOrder = Mockito.inOrder(mapper, repository);
        inOrder.verify(mapper).fromDto(any());
        inOrder.verify(repository).save(any());
        inOrder.verify(mapper).toDto(any());
    }


}
