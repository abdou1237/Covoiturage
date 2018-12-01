package com.covoiturage.dao;

import com.covoiturage.entities.User;

public interface IUser {

	public void register(User user);
	
	public User login(String email, String password);
	
	public User getUserByEmail(String email);
}
