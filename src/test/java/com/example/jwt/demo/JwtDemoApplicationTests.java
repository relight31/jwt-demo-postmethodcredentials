package com.example.jwt.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jwt.demo.repositories.UserRepository;

@SpringBootTest
class JwtDemoApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void loadDemoUser() {
		userRepository.addNewUser("fred", "fred", "USER");
	}
}
