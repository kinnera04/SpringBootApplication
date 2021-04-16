package test.application.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

import test.application.util.UserType;

@XmlRootElement(name= "user")
@XmlAccessorType
@Entity(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID")
	private Long id;

	@Column(name = "USER_NAME")
	private String userName;

	@org.springframework.data.annotation.Transient
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "Email")
	private String email;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIME")
	private Date creationTime;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_TIME")
	private Date updatedTime;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "DOB")
	private Date dateofBirth;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "USER_TYPE")
	private UserType userType;

	@ManyToOne
	private UserAddress userAddress;
	
	@ElementCollection
	@CollectionTable(name = "data")
	private List<String> oldPasswords = new ArrayList<String>();
	
	@Transient
	private String dateOfBirthString;
	
	

	public User() {
		super();
	}

	public User(String userName, String password, String email, Date dateofBirth,
			UserType userType,UserAddress userAddress,List<String> oldPwds) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.creationTime = new Date();
		this.dateofBirth = dateofBirth;
		this.userType = userType;
		this.userAddress = userAddress;
		if(oldPwds!=null && !oldPwds.isEmpty())
			this.oldPasswords = oldPwds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	// to display on view
	public String getDateOfBirthString() {
		return dateofBirth.toString();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}

	public List<String> getOldPasswords() {
		return oldPasswords;
	}

	public void setOldPasswords(List<String> oldPasswords) {
		this.oldPasswords = oldPasswords;
	}
	
	


	
	
}
