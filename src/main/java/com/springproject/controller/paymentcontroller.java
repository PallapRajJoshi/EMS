package com.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class paymentcontroller {
	@GetMapping("/paywith")
	public String getPaywith() {
		return "https://web.khalti.com/?csrt=7219649051935412224#/";
	}

}
