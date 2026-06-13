package com.codeREXus.journalApp.service;


import com.codeREXus.journalApp.Entity.User;
import com.codeREXus.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Mock
    private UserRepository userRepository;

//    @BeforeEach
//    void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    void loadByUsername(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString()))
                .thenReturn(User.builder().userName("testUser")
                        .password("testPassword")
                        .roles(new ArrayList<>())
                        .build());

        Assertions.assertNotNull(userDetailsServiceImpl.loadUserByUsername("ram"),"fails");
    }

}
