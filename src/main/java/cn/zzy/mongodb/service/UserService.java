package cn.zzy.mongodb.service;


import java.util.List;

import cn.zzy.mongodb.pojo.User;

public interface UserService {
	
	public User findByUserCode(String userCode);
	
	public List<User> queryAll();

}
