package com.noobs.codecoach.api;

import com.noobs.codecoach.service.dto.request.CreateSimpleUserDTO;
import com.noobs.codecoach.service.dto.request.CreateUserDTO;

import com.noobs.codecoach.service.UserService;
import com.noobs.codecoach.service.dto.response.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createSimpleUser(@RequestBody CreateSimpleUserDTO createSimpleUserDTO) {
        userService.createSimpleUser(createSimpleUserDTO);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUser(@PathVariable int id) throws IllegalArgumentException {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/{id}/become-a-coach", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateRoleToCoach(@PathVariable int id) {
        userService.updateRoleToCoach(id);
    }

    @GetMapping(path = "/user-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void editProfileInformation (@PathVariable int id, @RequestBody CreateSimpleUserDTO createSimpleUserDto){
        userService.editProfileInformation(id, createSimpleUserDto);
    }
}
