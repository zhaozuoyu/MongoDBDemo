package cn.zzy.mongodb.service.impl;

import java.util.List;

import cn.zzy.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zzy.mongodb.dao.UserDao;
import cn.zzy.mongodb.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findByUserCode(String userCode) {
		return userDao.findByUserCode(userCode);
	}

	@Override
	public List<User> queryAll() {
		List<User> users =null;
		users = userDao.queryAll();
		return users;
	}


}
