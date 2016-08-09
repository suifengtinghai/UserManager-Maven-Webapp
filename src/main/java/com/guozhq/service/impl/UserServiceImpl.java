package com.guozhq.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

import com.guozhq.dao.UserDao;
import com.guozhq.entity.User;
import com.guozhq.service.IUserService;
@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public User login(User user) {
		return userDao.login(user);

	}

	@Override
	public boolean register(User user) {
		boolean success = false;
		try{
			success = userDao.insert(user);
		}catch(Exception e){
			success = false;
		}
		return success;
	}

	@Override
	public List<User> queryAllUser() {
		return userDao.queryAllUser();
	}

}
