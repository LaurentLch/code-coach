package com.noobs.codecoach.api;

import com.noobs.codecoach.service.dto.request.CreateUserDTO;

import com.noobs.codecoach.service.UserService;
import com.noobs.codecoach.service.dto.response.GetUserProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(path = "/users", produces = "application/json")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json")
    public void createUser(@RequestBody CreateUserDTO createUserDTO) {
        userService.createUser(createUserDTO);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public GetUserProfileDTO getUserProfile(@PathVariable int id) throws IllegalArgumentException {
        return userService.getUserById(id);

    }


}
