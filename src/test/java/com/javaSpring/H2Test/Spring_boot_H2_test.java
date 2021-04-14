package com.javaSpring.H2Test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javaSpring.model.User;
import com.javaSpring.repository.UserRepository;
import com.javaSpring.util.UserType;

@SpringBootTest
public class Spring_boot_H2_test {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	@DisplayName("Create User Test ")
	void createUserTest() {
		
		User created = userRepository.save(getUser());
		
		assertTrue(created != null);
	}
	
	private User getUser() {
		
		User user = new User();
		user.setUserType(UserType.STUDENT);
		user.setUserName("username");
		user.setPassword("password");
		user.setDateofBirth(new Date());
		user.setCreationTime(new Date());
		
		return user;
	}
}
