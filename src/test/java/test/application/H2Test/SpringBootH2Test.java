package test.application.H2Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.application.model.User;
import test.application.repository.UserRepository;
import test.application.util.UserType;

@SpringBootTest
class SpringBootH2Test {

	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	void createUserTest() {
		
		User created = userRepository.save(getUser());
		
		assertNotNull(created);
	}
	
	private User getUser() {
		
		User user = new User();
		user.setUserType(UserType.STUDENT);
		user.setUserName("username");
		user.setPassword("password");
		user.setDateofBirth(new Date());
		user.setCreationTime(new Date());
		user.setOldPasswords(new ArrayList<>(Arrays.asList("pwd1","pwd2")));
		
		return user;
	}
}
