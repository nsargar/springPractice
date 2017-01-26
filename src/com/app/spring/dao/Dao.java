package com.app.spring.dao;

import java.util.List;

import com.app.spring.pojo.MyUser;
import com.app.spring.pojo.ServiceProvider;
import com.app.spring.pojo.Servicerequest;
import com.app.spring.pojo.Servicetype;



public interface Dao {

	public MyUser validate(String email,String password)throws Exception ;
	public void addUser(MyUser obj);
	public List<ServiceProvider> getSPbyBrand(String brand);
	public void addSP(ServiceProvider sp);
	public List<MyUser> getDetails(String email);
	public List<Servicetype> getServiceTypes();
	public int placeOrder(Servicerequest sr);
	public List<Servicerequest> getUserRequests(int cid);
	public List<Servicerequest> getSpRequests(int spid);
	public Servicerequest getSrById(int rid);
	public List<String> getAllBrands();
	
	
}
