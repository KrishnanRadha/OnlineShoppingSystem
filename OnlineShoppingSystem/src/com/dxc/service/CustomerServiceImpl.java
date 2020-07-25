package com.dxc.service;

import java.util.List;

import com.dxc.dao.CustomerDaoImpl;
import com.dxc.dao.ICustomerDao;
import com.dxc.pojos.OrderDetailes;
import com.dxc.pojos.Products;

public class CustomerServiceImpl  implements ICustomerService{

	ICustomerDao dao=new CustomerDaoImpl();
	@Override
	public boolean loginAuthendication(String name, String password) {
		return dao.loginAuthendication(name,password);
	}
	@Override
	public List<Products> displayProducts() {
		return dao.displayProducts();
	}
	@Override
	public int getId(String name, String password) {
		return dao.getId(name,password);
	}
	@Override
	public boolean addToCart(int pid, int cid) {
		return dao.addToCart(pid,cid);
	}
	@Override
	public List<Products> getCartList(int cid) {
		return dao.getCartList(cid);
	}
	@Override
	public Boolean orderProduct(int cid, int pid, double price,int quant) {
		return dao.orderProduct(cid,pid,price,quant);
	}
	@Override
	public List<OrderDetailes> getOrderList(int cid) {
		return dao.getOrderList(cid);
	}
	@Override
	public boolean addMoneyToWallet(int cid, double price) {
		return dao.addMoneyToWallet(cid,price);
	}
	@Override
	public boolean checkFromCart(int prodid, int cid) {
		return dao.checkFromCart(prodid,cid);
	}
	@Override
	public double getWalletBalance(int cid) {
		return dao.getWalletBalance(cid);
	}

}
