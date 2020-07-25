package com.dxc.service;

import java.util.List;

import com.dxc.pojos.OrderDetailes;
import com.dxc.pojos.Products;

public interface ICustomerService {

	boolean loginAuthendication(String name, String password);

	List<Products> displayProducts();

	int getId(String name, String password);

	boolean addToCart(int pid, int cid);

	List<Products> getCartList(int cid);

	Boolean orderProduct(int cid, int pid, double price,int quant);

	List<OrderDetailes> getOrderList(int cid);

	boolean addMoneyToWallet(int cid, double price);

	boolean checkFromCart(int prodid, int cid);

	double getWalletBalance(int cid);

}
