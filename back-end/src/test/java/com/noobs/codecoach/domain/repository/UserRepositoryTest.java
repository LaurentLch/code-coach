package com.noobs.codecoach.domain.repository;

//import static org.junit.jupiter.api.Assertions.*;

import com.noobs.codecoach.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void userCreate_ifUserCreated_returnUsersCountPlusOne() {
        long usersCount = userRepository.count();
        User user3 = new User("FNtest2", "LNtest2", "MAD2@gmail.com", "A2azerty");
        userRepository.save(user3);
        long usersCountNew = userRepository.count();
        assertThat(usersCountNew).isEqualTo(usersCount + 1);
    }

    @Test
    void createUser_ifUserInDatabase_thenReturnInfos() {
        User user1 = new User("FNtest1", "LNtest1", "MAD1@gmail.com", "A1azerty");
        userRepository.save(user1);
        assertThat(user1.getFirstName()).isEqualTo("FNtest1");
        assertThat(user1.getLastName()).isEqualTo("LNtest1");
        assertThat(user1.getEmail()).isEqualTo("MAD1@gmail.com");
        assertThat(user1.getPassword()).isEqualTo("A1azerty");
    }

    @Test
    void findUserByEmail_ifEmailInDatabase_thenReturnFirstName() {
        User user2 = new User("FNtest2", "LNtest2", "MAD2@gmail.com", "A2azerty");
        userRepository.save(user2);
        assertThat(userRepository.getUserByEmail("MAD2@gmail.com").getFirstName()).isEqualTo("FNtest2");
    }

    @Test
    void findUserById_ifUserInDatabase_thenReturnId() {
        User user3 = new User("FNtest3", "LNtest3", "MAD3@gmail.com", "A3azerty");
        userRepository.save(user3);
        assertThat(userRepository.getUserById(user3.getId()).getId()).isEqualTo(user3.getId());
    }


}
