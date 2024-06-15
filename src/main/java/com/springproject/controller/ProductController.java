package com.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springproject.repository.ProductRepositary;

@Controller
public class ProductController {
	@Autowired
	private ProductRepositary pr;
	@GetMapping("/productGallery")
	public String getImage(Model m) {
		m.addAttribute("plist",pr.findAll());
		return "ProductGalleryForm";
	}

}
