package com.dxc.service;

import java.util.List;

import com.dxc.pojos.Customers;
import com.dxc.pojos.OrderDetailes;
import com.dxc.pojos.Products;

public interface IAdminService {

	boolean loginAuthendication(String name, String password);

	boolean addProduct(Products product);

	boolean addCustomer(Customers customer);

	boolean removeCustomer(int cid);

	boolean removeProduct(int pid);

	List<Products> getProductList();

	List<OrderDetailes> getPOrderedListById(int cid);

	List<OrderDetailes> getAllPOrderedList();

	boolean findCustomer(int cid);

	List<Customers> getCustomerList();

	boolean removeOrder(int cid, int pid);

	boolean findProduct(int pid);

}
