package com.dxc.dao;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customers;
import com.dxc.pojos.OrderDetailes;
import com.dxc.pojos.Products;


public class AdminDaoImpl implements IAdminDao {

	private static SessionFactory sessionFactory;
	static
	{
		Configuration configuration=new Configuration().configure();
		sessionFactory=configuration.buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from Admin");
		List<Admin> list=query.getResultList();
		if(list.isEmpty())
		{
			Admin admin=new Admin();
			session.save(admin);
			
		}
		session.getTransaction().commit();
		
	}
			
		
	@Override
	public boolean loginAuthendication(String name, String password) {
		
		Session session=sessionFactory.openSession();
		
		Query query =session.createQuery("from Admin");
		List<Admin> list=query.getResultList();
		for(Admin ad:list)
		{
			if(name.equals(ad.getName())&& password.equals(ad.getPassword()))
			{
				return true;
			}
		}
		
		return false;
	}


	@Override
	public boolean addProduct(Products product) {
		
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(product);
		
		session.getTransaction().commit();
		return true;
		
	}


	private boolean findUserName(String uName) {
		Session session=sessionFactory.openSession();
		
		Query query =session.createQuery("from Customers");
		List<Customers> list=query.getResultList();
		for(Customers cust:list)
		{
			if(uName.equals(cust.getCname()))
			{
				return false;
			}
		}
		return true;
	}


	@Override
	public boolean findProduct(int pid) {
		
		Session session=sessionFactory.openSession();
		
		Query query =session.createQuery("from Products");
		List<Products> list=query.getResultList();
		for(Products pd:list)
		{
			if(pid==pd.getPid())
			{
				return true;
			}
		}
		
		return false;
	}


	@Override
	public boolean addCustomer(Customers customer) {
		if(this.findUserName(customer.getCname())==true)
		{
			Session session=sessionFactory.openSession();
			
			session.beginTransaction();
			
			session.save(customer);
			
			session.getTransaction().commit();
			
			return true;
		}else
		{
			return false;
		}
	}


	@Override
	public boolean removeCustomer(int cid) {
		if(this.findCustomer(cid)==true)
		{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			
			Query query=session.createQuery("delete from Customers where cid=:cid");
			query.setParameter("cid", cid);
			query.executeUpdate();
			
			session.getTransaction().commit();
			return true;
		}else
		{
			return false;
		}
		
	}
	
	@Override
	public boolean findCustomer(int cid) {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Customers");
		List<Customers> list=query.getResultList();
		
		for(Customers cust:list)
		{
			if(cid==cust.getCid())
			{
				return true;
			}
		}
		
		return false;
	}

	
	
	@Override
	public boolean removeProduct(int pid) {
		if(this.findProduct(pid)==true)
		{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Query query=session.createQuery("delete from Products where pid=:pid");
		query.setParameter("pid", pid);
		query.executeUpdate();
		
		session.getTransaction().commit();
		return true;
		}
		else
		{
			return false;
		}
	}


	@Override
	public List<Products> getProductList() {
		
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("from Products");
		
		return query.getResultList();
	}


	@Override
	public List<OrderDetailes> getPOrderedListById(int cid) {
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("from OrderDetailes where cid=:cid");
		query.setParameter("cid", cid);
		
		return query.getResultList();
	}


	@Override
	public List<OrderDetailes> getAllPOrderedList() {
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("from OrderDetailes");
		
		return query.getResultList();
	}


	@Override
	public List<Customers> getCustomerList() {
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("from Customers");
		
		return query.getResultList();
	}


	@Override
	public boolean removeOrder(int cid, int pid) {

		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		Query query=session.createQuery("delete from OrderDetailes where cid=:cid AND pid=:pid");
		query.setParameter("cid", cid);
		query.setParameter("pid", pid);
		query.executeUpdate();
		session.getTransaction().commit();
		
		return true;
	}


	
}
