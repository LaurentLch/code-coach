package com.noobs.codecoach.service.dto.request;

import lombok.Getter;

@Getter
public class CreateMemberDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
