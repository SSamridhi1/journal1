package com.codeREXus.journalApp.service;

import com.codeREXus.journalApp.Entity.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.codeREXus.journalApp.repository.UserRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTests {

    @Autowired
    private UserRepository userRepostory;
    @Disabled
    @Test
    public void testFindbyUsername(){
        assertNotNull(userRepostory.findByUserName("Anan"));
        assertEquals(4,2+2);
    }


    @ParameterizedTest
    @CsvSource({
        "Anan,pass",
        "John,John123",
        "Admin,password"
    })
    public void testFIndUserwithPassword(String username, String password){
        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = userRepostory.findByUserName(username);
        assertTrue(passwordEncoder.matches(password,user.getPassword()),"Password does not match for user: " + username);
    }



}
