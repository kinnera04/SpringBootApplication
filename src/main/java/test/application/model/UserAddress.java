package test.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@XmlRootElement(name="useraddress")
@Entity(name = "USERADDRESS")
public class UserAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID")
	private Long id;

	@Column(name="STREET")
    private String streetAddress;
	
	@Column(name="STATE")
    private String state;
	
	@Column(name="CITY")
    private String city;
	
    @Column(name="ZIP_CODE")
    private String areaCode;
    
    

	public UserAddress() {
		super();
	}

	public UserAddress(String streetAddress, String state, String city, String areaCode) {
		super();
		this.streetAddress = streetAddress;
		this.state = state;
		this.city = city;
		this.areaCode = areaCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
    
    
}
