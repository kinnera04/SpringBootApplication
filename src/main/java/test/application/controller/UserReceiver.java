package test.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import test.application.model.User;
import test.application.repository.UserAddressRepository;
import test.application.repository.UserRepository;



@Component
public class UserReceiver {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserAddressRepository userAddressRepo;
	
	  @JmsListener(destination = "sendingUsers", containerFactory = "myFactory") 
	  public void receiveMessage(User user) { 
		  userAddressRepo.save(user.getUserAddress());
		  userRepo.save(user);
	  }
	 
}
