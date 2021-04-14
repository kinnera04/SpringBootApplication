package test.application.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.application.dto.UserDTO;
import test.application.model.User;
import test.application.repository.UserAddressRepository;
import test.application.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserAddressRepository userAddressRepository;
	

	@GetMapping
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId){
			
		User user = userRepository.findById(userId)
				  .orElseThrow(() -> new NoSuchElementException("User not availbele for Id :"+userId));
				
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/createUser")
	public String createUser(@Valid @RequestBody UserDTO userDto) {
		User user = userDto.createUser();
		userAddressRepository.save(user.getUserAddress());
		userRepository.save(user);
		
		return "User - "+user.getUserName()+" details are saved "+"with user id - "+user.getId();
	}

}
