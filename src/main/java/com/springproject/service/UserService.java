package com.springproject.service;

import com.springproject.model.User;

public interface UserService {
	void userSignup(User user);
	User userLogin(String email,String pass);
}
