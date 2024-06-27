package com.userservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userservice.entity.User;
import com.userservice.exception.ResourseNotFoundException;
import com.userservice.repository.UserRespository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRespository userRespository;
	
	@Override
	public User saveUser(User user) {
		String uid = UUID.randomUUID().toString();
		user.setUserId(uid);
		return userRespository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRespository.findAll();
	}

	@Override
	public User getUser(String id) {
		
		return userRespository.findById(id).orElseThrow(()-> new ResourseNotFoundException("User is not find by id"));
	}

}
