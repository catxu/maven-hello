package com.catxu.user.dao;

import com.catxu.user.model.User;

public interface IUserDao {
	public void add(User u);
	public User loadByUsername(String username);
}
