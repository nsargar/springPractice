package com.app.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.spring.pojo.MyUser;
import com.app.spring.pojo.ServiceProvider;
import com.app.spring.pojo.Servicerequest;
import com.app.spring.pojo.Servicetype;



@Repository
public class DaoImpl implements Dao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public MyUser validate(String email, String password) throws Exception {
		
		Session hs=sessionFactory.getCurrentSession();
		Query hql=hs.createQuery("from MyUser where email= :email and password= :password");
		hql.setString("email", email);
		hql.setString("password", password);
		MyUser u1=(MyUser) hql.uniqueResult();
		System.out.println("in daoimpl validate"+u1+""+email+""+password);
		return u1;
	}


	@Override
	public void addUser(MyUser obj)
	{
		Session hs=sessionFactory.getCurrentSession();
		//Transaction ts=null;
		
		try{
		//ts=hs.beginTransaction();
		//hs.beginTransaction()
		hs.save(obj);
		//ts.commit();
		
		}catch(Exception e)
		{ 
			//ts.rollback();
			hs.clear();
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<MyUser> getDetails(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<ServiceProvider> getSPbyBrand(String brand) {
		// TODO Auto-generated method stub
		//List<ServiceProvider> ls=new ArrayList<ServiceProvider>();
		Query hql=sessionFactory.getCurrentSession().createQuery("from ServiceProvider where brand= :b");
		hql.setString("b", brand);
		List ls=hql.list();
		//ls=(ArrayList<ServiceProvider>)sessionFactory.getCurrentSession().createQuery("from ServiceProvider where brand= :brand").setString("brand", brand).list();
		
		System.out.println(ls+""+brand);
		
		return ls;
	}


	@Override
	public void addSP(ServiceProvider sp) {
		Session hs=sessionFactory.getCurrentSession();
		//Transaction ts=null;
		
		try{
		//ts=hs.beginTransaction();
		//hs.beginTransaction()
		hs.save(sp);
		//ts.commit();
		
		}catch(Exception e)
		{ 
			//ts.rollback();
			hs.clear();
			
			e.printStackTrace();
		}
		
	}


	@Override
	public List<Servicetype> getServiceTypes() {
		// TODO Auto-generated method stub
	
		return (ArrayList<Servicetype>)sessionFactory.getCurrentSession().createQuery("from Servicetype").list();
	}


	@Override
	public int placeOrder(Servicerequest sr) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		Servicerequest obj=(Servicerequest) session.createQuery("from Servicerequest where cid= :cid").setInteger("cid", sr.getCid()).uniqueResult();
		System.out.println(obj);
		if(obj==null)
		return (int)sessionFactory.getCurrentSession().save(sr);
		else return -1;
	}


	@Override
	public List<Servicerequest> getUserRequests(int cid) {
		// TODO Auto-generated method stub
		ArrayList<Servicerequest> ls=new ArrayList<Servicerequest>();
		Session sf=sessionFactory.getCurrentSession();
		
		Query query=sf.createQuery("from Servicerequest where cid= :cid").setInteger("cid", cid);
		ls=(ArrayList<Servicerequest>) query.list();
		
		return ls;
	}
	@Override
	public List<Servicerequest> getSpRequests(int spid) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("from Servicerequest where spid= :spid").setInteger("spid", spid);
		List<Servicerequest> ls=(ArrayList<Servicerequest>) query.list();
		System.out.println("in dao"+ls);
		
		return ls;
	}


	@Override
	public Servicerequest getSrById(int rid) {
		// TODO Auto-generated method stub
		
		return (Servicerequest) sessionFactory.getCurrentSession().get(Servicerequest.class, rid);
	}


	@Override
	public List<String> getAllBrands() {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}
	
	
	
	

}
