package com.userservice.service;

import java.util.List;

import com.userservice.entity.User;

public interface UserService {
	
    User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String id);
}
