package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.ProductDAO;

@Controller
public class CartController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping("/cart")
	public String showCart(HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		
		List<CartItem> listCartItem = cartDAO.listCartItem(username);
		m.addAttribute("cartItem", listCartItem);
		m.addAttribute("grandTotal", this.calcGrandTotalValue(listCartItem));
		return "Cart";
	}
	@RequestMapping("/addToCart/{productId}")
	public String addToCart(@PathVariable("productId")int productId,@RequestParam("quatity")int quantity,HttpSession session,Model m)
	{
		Product product =productDAO.getProduct(productId);
		String username=(String)session.getAttribute("username");
		CartItem cartItem=new  CartItem();
		cartItem.setProductId(product.getProductID());
		cartItem.setProductName(product.getProductName());
		cartItem.setPrice(product.getPrice());
		cartItem.setQuantity(quantity);
		cartItem.setPstatus("NP");
		cartItem.setUsername(username);
		cartDAO.addCartItem(cartItem);
		List<CartItem> listCartItem=cartDAO.listCartItem(username);
		m.addAttribute("cartItem", listCartItem);
		m.addAttribute("grandTotal", this.calcGrandTotalValue(listCartItem));
		
		return "Cart";
		
	}