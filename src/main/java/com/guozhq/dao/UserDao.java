package com.guozhq.dao;

import java.util.List;

import com.guozhq.entity.User;

public interface UserDao {
	public User login(User user);
	public boolean insert(User user);
	public List<User> queryAllUser();
}
