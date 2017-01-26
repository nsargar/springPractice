package com.app.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.spring.dao.DaoImpl;
import com.app.spring.pojo.MyUser;
import com.app.spring.pojo.ServiceProvider;
import com.app.spring.pojo.Servicerequest;
import com.app.spring.pojo.Servicetype;


@Service
@Transactional
public class ServiceClass {

	@Autowired
	private DaoImpl d;
	//private Transaction ts;
	
	public int placeOrder(Servicerequest sr)
	{
		return d.placeOrder(sr);
	}
	public List<Servicerequest> getSpRequests(int spid) {
		return d.getSpRequests(spid);
	}
	public List<Servicerequest> getUserRequests(int cid){
		return d.getUserRequests(cid);
	}
	
	
	public void addUser(MyUser obj){
		d.addUser(obj);
	}
	public void addSP(ServiceProvider obj){
		d.addSP(obj);
	}
	
	public MyUser validate(MyUser obj)throws Exception
	{
		System.out.println(obj);
		return d.validate(obj.getEmail(), obj.getPassword());
	}
	public List<ServiceProvider> getSPbyBrand(String brand){
		return d.getSPbyBrand(brand);
	}
	
	public List<Servicetype> getServiceTypes(){
		return d.getServiceTypes();
	}
	public Servicerequest getSrById(int rid){
		return d.getSrById(rid);
	}
	
}
