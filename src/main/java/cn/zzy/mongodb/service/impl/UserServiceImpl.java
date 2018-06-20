package cn.zzy.mongodb.service.impl;

import java.util.List;

import cn.zzy.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import cn.zzy.mongodb.dao.UserDao;
import cn.zzy.mongodb.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean save(Object obj, String collectionName) {
		return userDao.save(obj,collectionName);
	}


	@Override
	public <T> T findByKey(Class<?> clazz, Criteria criteria, String collectionName) {
		return userDao.findByKey(clazz,criteria,collectionName);
	}

	@Override
	public <T> List<T> findAll(Class<T> clazz, String collectionName) {
		return userDao.findAll(clazz,collectionName);
	}



}
