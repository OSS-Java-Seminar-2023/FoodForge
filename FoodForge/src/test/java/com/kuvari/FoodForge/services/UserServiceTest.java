package com.kuvari.FoodForge.services;

import com.kuvari.FoodForge.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    void testSuccessfulRegistration() {
        var userDto = new UserDto("testUser1","test1@example.com","PasswordJakKoStena123");

        userService.registerUser(userDto);

        userService.userRepository.findByUsername("testUser1").ifPresent(user -> assertNotNull(user.getUsername()));

    }

    @Test
    void registerExistingUserToTriggerAnException() {
        var userDto = new UserDto("testUser1","test1@example.com","PasswordJakKoStena123");

        assertThrows(RuntimeException.class,() -> userService.registerUser(userDto));

    }

    @Test
    void testSuccessfulLogin(){
        assertTrue(userService.loginUser("testUser1","PasswordJakKoStena123"));
    }
}