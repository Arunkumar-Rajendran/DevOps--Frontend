package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping(value = "/product")
	public String showManageProduct(Model m) {

		Product product = new Product();
		m.addAttribute("product", product);

		List<Product> listProduct = productDAO.listProduct();
		m.addAttribute("productList", listProduct);

		List<Category> listCategory = categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(listCategory));

		List<Supplier> listSupplier = supplierDAO.listSupplier();
		m.addAttribute("supplierList", this.getSupplierList(listSupplier));

		return "Product";
	}

}