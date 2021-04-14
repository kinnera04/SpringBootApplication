package com.javaSpring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javaSpring.model.User;
import com.javaSpring.repository.UserRepository;
import com.javaSpring.util.UserType;

@SpringBootApplication
public class SpringBootRestAndJPAApplication {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestAndJPAApplication.class, args);
	}

	@PostConstruct
	private void initDb() {
		for(User user : createUsers())
		userRepository.save(user);
	}
	
	private List<User> createUsers() {
		List<User> users = new ArrayList<User>();
		Date date = new Date();
		User user = new User("test1","test1","test1@gmail.com",date,date,UserType.STUDENT);;

		User user1 = new User("test2","test2","test2@gmail.com",date,date,UserType.EMPLOYEE);;
		User user2 = new User("test3","test3","test3@gmail.com",date,date,UserType.EMPLOYEE);;

		users.add(user);
		users.add(user1);
		return users;
	}

}
