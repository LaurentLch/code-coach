package com.noobs.codecoach.api;

import com.noobs.codecoach.service.dto.request.CreateSimpleUserDTO;
import com.noobs.codecoach.service.dto.request.CreateUserDTO;

import com.noobs.codecoach.service.UserService;
import com.noobs.codecoach.service.dto.response.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json")
    public void createSimpleUser(@RequestBody CreateSimpleUserDTO createSimpleUserDTO) {
        userService.createSimpleUser(createSimpleUserDTO);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUser(@PathVariable int id) throws IllegalArgumentException {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/{id}/become-a-coach", consumes = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateRoleToCoach(@PathVariable int id) {
        userService.updateRoleToCoach(id);
    }


}
