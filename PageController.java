package com.niit.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PageController {
	@RequestMapping("/index")
	public String ShowIndexPage() {
		return "index";
	}

	@RequestMapping("/login")
	public String ShowloginPage() {
		return "Login";
	}

	@RequestMapping("/register")
	public String ShowRegisterPage() {
		return "Register";
	}

	@RequestMapping("/contactus")
	public String ShowContactUsPage() {
		return "Contactus";
	}
}