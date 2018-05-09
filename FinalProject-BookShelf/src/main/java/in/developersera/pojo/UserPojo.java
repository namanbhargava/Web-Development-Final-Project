package in.developersera.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="user_tbl")
public class UserPojo {
	
	@Id
	@Column(name="userid")
	String userid;
	
	@Column(name="password", unique=true, nullable=false)
	String password;

	@Column(name="fname", unique=false, nullable=false)
	String fname;
	
	@Column(name="lname", unique=false, nullable=false)
	String lname;
	
	@Column(name="city", unique=false, nullable=false)
	String city;
	
	@Column(name="state", unique=false, nullable=false)
	String state;
	
	@Column(name="phoneNumber", unique=false, nullable=false)
	String phoneNumber;
	
	@Column(name="address", unique=false, nullable=false)
	String address;
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(mappedBy="userpojo", cascade=CascadeType.ALL)
	private Set<Cart> cart;
	
	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
