package com.noobs.codecoach.domain.repository;

import com.noobs.codecoach.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByEmail(String Email);

    User getUserById(int id);

    List<User> findAll();

}
