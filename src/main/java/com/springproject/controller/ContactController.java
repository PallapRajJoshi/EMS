package com.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.utils.MailUtils;



@Controller
public class ContactController {
	@Autowired
	private MailUtils ms;
	@GetMapping("/contact")
	public String getContact() {
		return "ContactForm";
	}
	
	
	
	@PostMapping("/contact")
	public String postContact(@RequestParam String toEmail,@RequestParam String subject,@RequestParam String message) {
		ms.sendEmail( toEmail, subject,message);
		return "ContactForm";
	}

}
