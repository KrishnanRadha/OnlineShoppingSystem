package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.Customers;
import com.dxc.pojos.OrderDetailes;
import com.dxc.pojos.Products;

public interface IAdminDao {

	boolean loginAuthendication(String name, String password);

	boolean addProduct(Products product);

	boolean findProduct(int pid);

	boolean addCustomer(Customers customer);

	boolean removeCustomer(int cid);

	boolean removeProduct(int pid);

	List<Products> getProductList();
	
	boolean findCustomer(int cid);

	List<OrderDetailes> getPOrderedListById(int cid);

	List<OrderDetailes> getAllPOrderedList();

	List<Customers> getCustomerList();

	boolean removeOrder(int cid, int pid);
}
