package com.springproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.model.User;
import com.springproject.repository.UserRepository;
import com.springproject.service.UserService;
@Service //here we have to write business logics of the system
public class UserServiceImpl implements UserService {
	@Autowired
private UserRepository userRepo;
	@Override
	public void userSignup(User user) {
		
		userRepo.save(user);
	}

	@Override
	public User userLogin(String email, String pass) {
		
	return userRepo.findByEmailAndPassword(email,pass);
		
	}

}
