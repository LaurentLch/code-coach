package com.noobs.codecoach.domain.entity;

import com.noobs.codecoach.infrastructure.utils.MailAddressValidator;
import com.noobs.codecoach.infrastructure.utils.PasswordValidator;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

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

    @Column(name = "role")
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_info_id", referencedColumnName = "id")
    private CoachInfo coachInfo;

    public User(String firstName, String lastName, String email, String password) {
        validateInput(firstName, lastName, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = Role.COACHEE.getRoleName();
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public CoachInfo getCoachInfo() {
        return coachInfo;
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
