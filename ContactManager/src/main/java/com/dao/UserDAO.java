package com.dao;

import com.model.User;

public interface UserDAO {
	User login(String email,String password);
	boolean register(String email,String name,String password);
}
