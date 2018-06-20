package cn.zzy.mongodb.service;


import java.util.List;

import cn.zzy.mongodb.pojo.User;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public interface UserService {

	boolean save(Object obj,String collectionName);

	<T> T findByKey(Class<?> clazz, Criteria criteria, String collectionName);

	<T>  List<T> findAll(Class<T> clazz,String collectionName);

}
