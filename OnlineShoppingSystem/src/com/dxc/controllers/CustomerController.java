package com.dxc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.OrderDetailes;
import com.dxc.pojos.Products;
import com.dxc.service.CustomerServiceImpl;
import com.dxc.service.ICustomerService;

@Controller

public class CustomerController {
	
	ICustomerService service=new CustomerServiceImpl();
	private int cid;
	private int pid;
	private Products prod;
	private int quant;
	private double price;
	
	@RequestMapping(value="/custpmerslogin",method=RequestMethod.POST)
	public String customersLogin(@RequestParam String name,@RequestParam String password,@RequestParam String op,Model model)
	{
		cid=service.getId(name,password);
		boolean b=service.loginAuthendication(name,password);
		if(b==true) {
			model.addAttribute("op", op);
			model.addAttribute("message", "Successfully logined");
			return "displayproduct";
		}
		else {
			model.addAttribute("message", "Name & Password Incorrect");
			return "view";
		}
	}
	
	
	@RequestMapping(value="/display_products",method=RequestMethod.POST)
	public String displayProduct(@RequestParam String op,Model model)
	{
		List<Products> list=service.displayProducts();
		
			model.addAttribute("op", op);
			model.addAttribute("list", list);
			return "displayproduct";
	}
	

	@RequestMapping(value="/cart_order",method=RequestMethod.POST)
	public String addtoCartOrOrder(@ModelAttribute Products product,@RequestParam String op,Model model)
	{
		prod=product;
		pid=product.getPid();
		price=prod.getPrice();
		if(op.equals("Add_to_Cart"))
		{
			int prodid=product.getPid();
			boolean b1=service.checkFromCart(prodid,cid);
			if(b1==true)
			{
				boolean b=service.addToCart(prodid,cid);
				if(b==true)
				{
					model.addAttribute("message", "Successfully added to cart");
					return "view";
				}else
				{
					model.addAttribute("message", "Somthing Error in added to cart");
					return "view";
				}
			}else
			{
				model.addAttribute("message", "This Product already precent in Cart");
				return "view";
			}
		}
		else if(op.equals("Order"))
		{
			model.addAttribute("prod",product);
			return "quantityconfirmation";
		}
		
		return null;
	}
	
	
	
	@RequestMapping(value="/quantcount",method=RequestMethod.POST)
	public String quantCount(@RequestParam int quant,@RequestParam String op,Model model)
	{
		if(op.equals("Confirm"))
		{
			if(quant<=prod.getQuant())
			{
				prod.setQuant(quant);
				model.addAttribute("prod",prod);
				return "displaybill";
			}
		}
		String message=""+prod.getQuant()+" items only having";
		model.addAttribute("message",message);
		return "view";
	}
	
	
	@RequestMapping(value="/displaycartlist",method=RequestMethod.POST)
	public String displayCartList(@RequestParam String op,Model model)
	{
		List<Products> list=service.getCartList(cid);
		model.addAttribute("list",list);
		model.addAttribute("op",op);
		return "displayproduct_fromcart";
	}
	
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public String orderProduct(@RequestParam int pid,@RequestParam int quant,@RequestParam double price,@RequestParam String op,Model model)
	{
		Boolean b=service.orderProduct(cid,pid,price,quant);
		if(b==true)
		{
			model.addAttribute("message", "Successfully Product ordered");
			return "view";
		}else
		{
			model.addAttribute("message", "Somthing Wrong in Ordering");
			return "view";
		}
	}
	
	
	@RequestMapping(value="/ordered_detailes",method=RequestMethod.POST)
	public String orderDetailsList(@RequestParam String op,Model model)
	{
		List<OrderDetailes> list=service.getOrderList(cid);
		model.addAttribute("list",list);
		model.addAttribute("op",op);
		return "displayordereddetails";
	}
	
	
	@RequestMapping(value="/add_money",method=RequestMethod.POST)
	public String addMoneyToWallet(@RequestParam double price,@RequestParam String op,Model model)
	{
		boolean b=service.addMoneyToWallet(cid,price);
		
		if(b==true)
		{
			model.addAttribute("message", "Successfully Money Added to Wallet");
			return "view";
		}else
		{
			model.addAttribute("message", "Somthing Wrong in add money to Wallet");
			return "view";
		}
	}
	
	@RequestMapping("/showbalance")
	public String showbalance(Model m)
	{
		double balance=service.getWalletBalance(cid);
		System.out.println(balance);
		m.addAttribute("balance",balance);
		return "showBalance";
	}
	
}
