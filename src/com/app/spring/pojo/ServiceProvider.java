package com.app.spring.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the serviceprovider database table.
 * 
 */
@Entity
//@NamedQuery(name="Serviceprovider.findAll", query="SELECT s FROM Serviceprovider s")
public class ServiceProvider implements Serializable {
	@Override
	public String toString() {
		return "ServiceProvider [id=" + id + ", address=" + address
				+ ", brand=" + brand + ", contactLandline=" + contactLandline
				+ ", contactMobile=" + contactMobile + ", email=" + email
				+ ", name=" + name + ", password=" + password + "]";
	}

	private static final long serialVersionUID = 1L;
	private int id;
	private String address;
	private String brand;
	private String contactLandline;
	private String contactMobile;
	private String email;
	private String name;
	private String password;

	public ServiceProvider() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getContactLandline() {
		return this.contactLandline;
	}

	public void setContactLandline(String contactLandline) {
		this.contactLandline = contactLandline;
	}


	public String getContactMobile() {
		return this.contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}