package test.application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import test.application.model.User;
import test.application.model.UserAddress;
import test.application.repository.UserAddressRepository;
import test.application.repository.UserRepository;
import test.application.util.UserType;

@SpringBootApplication
public class SpringBootRestAndJPAApplication {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserAddressRepository userAddressRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestAndJPAApplication.class, args);
	}

	@PostConstruct
	private void initDb() {
		for(User user : createUsers()) {
		userRepository.save(user);
		}
	}
	
	private List<User> createUsers() {
		List<User> users = new ArrayList<>();
		Date date = new Date();
		UserAddress address = new UserAddress("test1Street","test1State",
				"test1City","test1ZipCode");
		UserAddress address1 = new UserAddress("test2Street","test2State",
				"test2City","test2ZipCode");
		userAddressRepository.save(address);
		userAddressRepository.save(address1);
		User user = new User("test1","test1","test1@gmail.com",
				date,date,UserType.STUDENT,address);

		User user1 = new User("test2","test2","test2@gmail.com",
				date,date,UserType.EMPLOYEE,address1);

		users.add(user);
		users.add(user1);
		return users;
	}

}
