package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierController {

	@Autowired
	SupplierDAO supplierDAO;

	public String showSupplierPage(Model m) {
		List<Supplier> listsupplier = supplierDAO.listSupplier();

		m.addAttribute("supplierList", listsupplier);

		return "Supplier";
	}

	public String addSupplier(@RequestParam("supplierName") String supplierName,
			@RequestParam("supplierDesc") String supplierDesc, Model m) {

		Supplier supplier = new Supplier();
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddress(supplierDesc);

		supplierDAO.addSupplier(supplier);

		List<Supplier> listSupplier = supplierDAO.listSupplier();
		m.addAttribute("supplierList", listSupplier);

		return "Supplier";

	}

