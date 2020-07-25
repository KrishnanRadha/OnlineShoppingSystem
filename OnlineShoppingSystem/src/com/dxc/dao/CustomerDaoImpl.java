package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Cart;
import com.dxc.pojos.Customers;
import com.dxc.pojos.OrderDetailes;
import com.dxc.pojos.Products;

public class CustomerDaoImpl implements ICustomerDao {

		private static SessionFactory sessionFactory;
		static
		{
			Configuration configuration=new Configuration().configure();
			sessionFactory=configuration.buildSessionFactory();
		}
				
			
		@Override
		public boolean loginAuthendication(String name, String password) {
			
			Session session=sessionFactory.openSession();
			
			Query query =session.createQuery("from Customers");
			List<Customers> list=query.getResultList();
			for(Customers cus:list)
			{
				if(name.equals(cus.getCname())&& password.equals(cus.getPassword()))
				{
					return true;
				}
			}
			
			return false;
		}


		@Override
		public List<Products> displayProducts() {
			Session session=sessionFactory.openSession();
			
			Query query=session.createQuery("from Products");
			List<Products> list=query.getResultList();
			return list;
		}


		@Override
		public int getId(String name, String password) {
			
			Session session=sessionFactory.openSession();
			int id=0;
			Query query=session.createQuery("from Customers");
			
			List<Customers> list=query.getResultList();
			for(Customers cus:list)
			{
				if(name.equals(cus.getCname()) && password.equals(cus.getPassword()))
				{
					id=cus.getCid();
				}
			}
			return id;
		}


		@Override
		public boolean addToCart(int pid, int cid) {
			Cart cart=new Cart();
			cart.setCid(cid);
			cart.setPid(pid);
			
			Session session=sessionFactory.openSession();
			
			session.beginTransaction();
			session.save(cart);
			session.getTransaction().commit();
			
			return true;
		}


		@Override
		public List<Products> getCartList(int cid) {
			List<Products> list=new ArrayList<Products>();
			
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Cart");
			List<Cart> clist=query.getResultList();
			for(Cart cart:clist)
			{
				if(cid==cart.getCid())
				{
					int pid=cart.getPid();
					Query query1=session.createQuery("from Products where pid=:pid");
					query1.setParameter("pid", pid);
					List<Products> list3=query1.getResultList();
					for(Products product:list3)
					{
						list.add(product);
					}
				}
			}
			
			
			
			return list;
		}


		@Override
		public Boolean orderProduct(int cid, int pid, double price,int quant) {
			OrderDetailes od=new OrderDetailes();
			int quantity=0;
			
			od.setCid(cid);
			od.setPid(pid);
			od.setCost(price);
			od.setQuant(quant);
			
			Session session1=sessionFactory.openSession();
			session1.beginTransaction();
			Query query1=session1.createQuery("from Products where pid=:pid");
			query1.setParameter("pid", pid);
			List<Products> list1=query1.getResultList();
			for(Products prod:list1)
			{
				quantity=prod.getQuant()-quant;
				
			}
			
			
			Query query3=session1.createQuery("from Customers where cid=:cid");
			query3.setParameter("cid", cid);
			List<Customers> list2=query3.getResultList();
			for(Customers cust:list2)
			{
				double cost=cust.getWallet();
				if(cost>=price)
				{
					cost=cost-price;
					Query query4=session1.createQuery("update Customers set wallet=:price where cid=:cid");
					query4.setParameter("price", cost);
					query4.setParameter("cid", cid);
					query4.executeUpdate();
				}else
				{
					return false;
				}
				
			}
			
			if(quantity>0)
			{
				Query query2=session1.createQuery("update Products set quant=:quant where pid=:pid");
				query2.setParameter("quant", quantity);
				query2.setParameter("pid", pid);
				query2.executeUpdate();
			}else
			{
				Query query2=session1.createQuery("delete from Products where pid=:pid");
				query2.setParameter("pid", pid);
				query2.executeUpdate();
			}
		
			
			
			Query query5=session1.createQuery("delete from Cart where cid=:cid AND pid=:pid");
			query5.setParameter("cid", cid);
			query5.setParameter("pid", pid);
			query5.executeUpdate();
			
			session1.save(od);
			
			session1.getTransaction().commit();
			
			return true;
			
		}


		@Override
		public List<OrderDetailes> getOrderList(int cid) {
			
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from OrderDetailes where cid=:cid");
			query.setParameter("cid", cid);
			return	query.getResultList();
		}


		@Override
		public boolean addMoneyToWallet(int cid, double price){
			
			Session session=sessionFactory.openSession();
			
			session.beginTransaction();
			Query query=session.createQuery("from Customers where cid=:cid");
			query.setParameter("cid", cid);
			List<Customers> list=query.getResultList();
			for(Customers cust:list)
			{
				double money=cust.getWallet();
				money=money+price;
				Query query1=session.createQuery("update Customers set wallet=:price where cid=:cid");
				query1.setParameter("price", money);
				query1.setParameter("cid", cid);
				query1.executeUpdate();
				
			}
			
			session.getTransaction().commit();
			
			return true;
		}


		@Override
		public boolean checkFromCart(int prodid, int cid) {
			
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Cart");
			List<Cart> list=query.getResultList();
			for(Cart cart:list)
			{
				if(cid==cart.getCid() && prodid==cart.getPid())
				{
					return false;
				}
			}
			return true;
		}


		@Override
		public double getWalletBalance(int cid) {
			double balance=0;
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Customers where cid=:cid");
			query.setParameter("cid",cid);
			List<Customers> list=query.getResultList();
			for(Customers cust:list)
			{
				balance=cust.getWallet();
			}
			return balance;
		}	

}
