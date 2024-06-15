package com.springproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springproject.model.User;
import com.springproject.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@GetMapping({"/","/login" })
	public String getLogin() {
		return "LoginForm";
	}

	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model m,HttpSession session) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User usr = userService.userLogin(user.getEmail(), user.getPassword());
		if (usr != null) {
			log.info("-------User Login Success-----------");
		session.setAttribute("activeuser", usr);
		session.setMaxInactiveInterval(120);
			return "Home";
		}
		m.addAttribute("message", "User not Found");
		return "LoginForm";
	}

	@GetMapping("/signup")
	public String getSignup() {
		return "SignUp";
	}

	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute User user) {
		// encryption
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.userSignup(user);

		return "LoginForm";

	}

	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
session.invalidate();
		return "LoginForm";
	}
	
	@GetMapping("/profile")
	public String getProfile() {
		return "profile";
	}

}
