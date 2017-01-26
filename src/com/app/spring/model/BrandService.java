package com.app.spring.model;



public class BrandService {

	private String brand;
	private String serviceType,city;
//adding comment to test push	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	@Override
	public String toString() {
		return "BrandService [brand=" + brand + ", serviceType=" + serviceType
				+ ", city=" + city + "]";
	}
	
	
	
}
