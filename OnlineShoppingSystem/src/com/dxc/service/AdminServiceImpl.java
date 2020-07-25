package com.dxc.service;

import java.util.List;

import com.dxc.dao.AdminDaoImpl;
import com.dxc.dao.IAdminDao;
import com.dxc.pojos.Customers;
import com.dxc.pojos.OrderDetailes;
import com.dxc.pojos.Products;

public class AdminServiceImpl implements IAdminService{

	IAdminDao dao=new AdminDaoImpl();
	
	@Override
	public boolean loginAuthendication(String name, String password) {
		return dao.loginAuthendication(name,password);
	}

	@Override
	public boolean addProduct(Products product) {
		return dao.addProduct(product);
	}


	@Override
	public boolean addCustomer(Customers customer) {
		return dao.addCustomer(customer);
	}

	@Override
	public boolean removeCustomer(int cid) {
		return dao.removeCustomer(cid);
	}

	@Override
	public boolean removeProduct(int pid) {
		return dao.removeProduct(pid);
	}

	@Override
	public List<Products> getProductList() {
		return dao.getProductList();
	}

	@Override
	public List<OrderDetailes> getPOrderedListById(int cid) {
		return dao.getPOrderedListById(cid);
	}

	@Override
	public List<OrderDetailes> getAllPOrderedList() {
		return dao.getAllPOrderedList();
	}

	@Override
	public boolean findCustomer(int cid) {
		return dao.findCustomer(cid);
	}

	@Override
	public List<Customers> getCustomerList() {
		return dao.getCustomerList();
	}

	@Override
	public boolean removeOrder(int cid, int pid) {
		return dao.removeOrder(cid,pid);
	}

	@Override
	public boolean findProduct(int pid) {
		return  dao.findProduct(pid);
	}

}
