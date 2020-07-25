package com.dxc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Customers;
import com.dxc.pojos.OrderDetailes;
import com.dxc.pojos.Products;
import com.dxc.service.AdminServiceImpl;
import com.dxc.service.IAdminService;

@Controller
public class AdminController 
{
	IAdminService service=new AdminServiceImpl();
	
	@RequestMapping("/adminlogin")
	public String adminLogin(@RequestParam String name,@RequestParam String password,@RequestParam String op,Model model)
	{
		boolean b=service.loginAuthendication(name,password);
		if(b==true) {
			model.addAttribute("op", op);
			model.addAttribute("message", "Successfully logined");
			return "admin_view";
		}
		else {
			model.addAttribute("message", "Name & Password Incorrect");
			return "view";
		}
			
	}

	
	@RequestMapping( value="/add_product",method=RequestMethod.POST)
	public String addProduct(@ModelAttribute Products product,@RequestParam String op,Model model)
	{
		boolean b1=service.findProduct(product.getPid());
		if(b1==false)
		{
			boolean b=service.addProduct(product);
			if(b==true)
			{
				model.addAttribute("op", op);
				model.addAttribute("message", "Successfully Product Added");
				return "admin_view";
			}
			else
			{
				model.addAttribute("message", "Product Not Added");
				return "admin_view";
			}
		}else
		{
			String message=product.getPid()+" this ProductId is already present.Please enter another Id...";
			model.addAttribute("message", message);
			return "view";
		}
	}

	@RequestMapping( value="/add_customer",method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute Customers customer,@RequestParam String op,Model model)
	{
		boolean b1=service.findCustomer(customer.getCid());
		if(b1==false)
		{
			boolean b=service.addCustomer(customer);
			model.addAttribute("op", op);
			if(b==true)
			{
				model.addAttribute("message", "Successfully Customer Added");
				return "admin_view";
			}
			else
			{
				String message=customer.getCname()+" this Customer Name is already present.Please enter another name...";
				model.addAttribute("message", message);
				return "view";
			}
		}else
		{
			String message=customer.getCid()+" this CustomerId is already present.Please enter another Id...";
			model.addAttribute("message", message);
			return "view";
		}
	}

	
	@RequestMapping( value="/remove_customer",method=RequestMethod.POST)
	public String removeCustomer(@RequestParam int cid,@RequestParam String op,Model model)
	{
		boolean b=service.removeCustomer(cid);
		model.addAttribute("op", op);
		if(b==true)
		{
			model.addAttribute("message", "Successfully Customer deleted");
			return "admin_view";
		}
		else
		{
			model.addAttribute("message", "Customer is not find");
			return "admin_view";
		}
	}


	@RequestMapping( value="/remove_product",method=RequestMethod.POST)
	public String removeProduct(@RequestParam int pid,@RequestParam String op,Model model)
	{
		boolean b=service.removeProduct(pid);
		model.addAttribute("op", op);
		if(b==true)
		{
			model.addAttribute("message", "Successfully Product deleted");
			return "admin_view";
		}
		else
		{
			model.addAttribute("message", "Product Not Found");
			return "admin_view";
		}
	}
	
	
	@RequestMapping("/display_products")
	public String displayProduct(@RequestParam String op,Model model)
	{
		List<Products> list=service.getProductList();
		model.addAttribute("list", list);
		model.addAttribute("op", op);
		return "admin_view";
	}
	
	
	@RequestMapping("/display_customers")
	public String displayPCustomer(@RequestParam String op,Model model)
	{
		List<Customers> list=service.getCustomerList();
		model.addAttribute("list", list);
		model.addAttribute("op", op);
		return "admin_view";
	}
	
	@RequestMapping(value="/orderedrdetailesid",method=RequestMethod.POST)
	public String orderedDetailsById(@RequestParam int cid,Model model)
	{
		if(service.findCustomer(cid)==true)
		{
			List<OrderDetailes> list=service.getPOrderedListById(cid);
			model.addAttribute("list", list);
			model.addAttribute("op", "orderdetailes");
			return "admin_view";
		}else
		{
			model.addAttribute("op", "Message");
			model.addAttribute("message", "Customer Not Found");
			return "admin_view";
		}
	}
	
	
	@RequestMapping(value="/orderdetailes",method=RequestMethod.POST)
	public String allOrderedDetails(Model model)
	{
		List<OrderDetailes> list=service.getAllPOrderedList();
		model.addAttribute("list", list);
		model.addAttribute("op", "orderdetailes");
		return "admin_view";
	}

	@RequestMapping( value="/delivered")
	public String removeOrderedProduct(@RequestParam int cid,@RequestParam int pid,@RequestParam String op,Model model)
	{
		boolean b=service.removeOrder(cid,pid);
		model.addAttribute("op", "Message");
		if(b==true)
		{
			model.addAttribute("message", "Successfully Order deleted");
			return "admin_view";
		}
		else
		{
			model.addAttribute("message", "Somthing Wrong!!!");
			return "admin_view";
		}
	}

	
}
