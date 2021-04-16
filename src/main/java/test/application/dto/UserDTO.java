package test.application.dto;

import java.util.Date;
import java.util.List;

import test.application.model.User;
import test.application.model.UserAddress;
import test.application.util.UserType;

public class UserDTO {
	
	private Long id;

	private String userName;

	private String password;
	
	private String email;

	private Date creationTime;

	private Date updatedTime;

	private Date dateofBirth;

	private UserType userType;

	private UserAddress userAddress;
	
	private List<String> oldPasswords;
	
	public User createUser() {
		User user = new User();
		user.setUserName(this.getUserName());
		user.setPassword(this.getPassword());
		user.setUserAddress(this.getUserAddress());
		user.setCreationTime(new Date());
		user.setEmail(this.getEmail());
		user.setUserType(this.getUserType());
		user.setDateofBirth(this.getDateofBirth());
		if(this.oldPasswords!=null && !this.oldPasswords.isEmpty())
			user.setOldPasswords(this.oldPasswords);
		return user;
	}
	
	public UserDTO toUserDTO(User user) {
		this.setId(user.getId());
		this.setUserName(user.getUserName());
		this.setPassword(user.getPassword());
		this.setUserAddress(user.getUserAddress());
		this.setCreationTime(user.getUpdatedTime());
		this.setEmail(user.getEmail());
		this.setUserType(user.getUserType());
		this.setUpdatedTime(user.getUpdatedTime());
		this.setDateofBirth(user.getDateofBirth());
		if(user.getOldPasswords()!=null && !user.getOldPasswords().isEmpty())
			this.setOldPasswords(oldPasswords);
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getOldPasswords() {
		return oldPasswords;
	}

	public void setOldPasswords(List<String> oldPasswords) {
		this.oldPasswords = oldPasswords;
	}
	
	
	
	

}
