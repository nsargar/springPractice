package com.app.spring.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the myuser database table.
 * 
 */
@Entity
//@NamedQuery(name="Myuser.findAll", query="SELECT m FROM Myuser m")
public class MyUser implements Serializable {
	@Override
	public String toString() {
		return "MyUser [id=" + id + ", address=" + address + ", city=" + city
				+ ", customerName=" + customerName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", password=" + password
				+ "]";
	}

	private static final long serialVersionUID = 1L;
	private int id;
	private String address;
	private String city;
	private String customerName;
	private String email;
	private String mobileNumber;
	private String password;

	public MyUser() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}