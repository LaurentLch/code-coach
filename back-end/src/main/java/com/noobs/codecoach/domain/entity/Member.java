package com.noobs.codecoach.domain.entity;

import com.noobs.codecoach.infrastructure.utils.MailAddressValidator;
import com.noobs.codecoach.infrastructure.utils.PasswordValidator;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Member(String firstName, String lastName, String email, String password) {
        validateInput(firstName, lastName, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    private void validateInput(String firstname, String lastname, String email, String password) {
        MailAddressValidator.assertValidEmailAdress(email);
        PasswordValidator.assertValidPassword(password);
        if (firstname == null) {
            throw new IllegalArgumentException("Wrong argument provided, firstname is null");
        }
        if (firstname.isEmpty() || firstname.isBlank()) {
            throw new IllegalArgumentException("Wrong argument provided, firstname is empty");
        }
        if (lastname == null) {
            throw new IllegalArgumentException("Wrong argument provided, lastname is null");
        }
        if (lastname.isEmpty() || lastname.isBlank()) {
            throw new IllegalArgumentException("Wrong argument provided, lastname is empty");
        }
        if (password == null) {
            throw new IllegalArgumentException("Wrong argument provided, password is null");
        }
        if (password.isEmpty() || password.isBlank()) {
            throw new IllegalArgumentException("Wrong argument provided, password is empty");
        }

    }


}
