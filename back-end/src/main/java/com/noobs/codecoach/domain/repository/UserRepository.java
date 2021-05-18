package com.noobs.codecoach.domain.repository;

import com.noobs.codecoach.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    public User getUserByEmail(String Email);

    public User getUserById(Integer id);

}
