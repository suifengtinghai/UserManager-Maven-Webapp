package com.guozhq.service;

import java.util.List;

import com.guozhq.entity.User;

public interface IUserService {
	public User login(User user);
	public boolean register(User user);
	public List<User> queryAllUser();
}
