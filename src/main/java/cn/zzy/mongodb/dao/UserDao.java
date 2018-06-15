package cn.zzy.mongodb.dao;

import java.util.List;

import cn.zzy.mongodb.pojo.User;

public interface UserDao {
	
	public User findByUserCode(String userCode);
	
	public List<User> queryAll();

}
