package cn.zzy.mongodb.dao;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public interface UserDao {

	/**根据对象添加指定的信息*/
	boolean save(Object obj,String collectionName);

	/**添加或修改指定的信息*/
	boolean saveOrUpdate(Object obj,String collectionName);

	/**根据对象属性_id删除指定的信息*/
	boolean remove(Object obj,String collectionName);

	/**根据查询条件删除指定的信息*/
	boolean removeByKey(Query query,String collectionName);

	boolean removeByKey(Class<?> clazz,Query query,String collectionName);

	boolean removeAll(String collectionName);

	boolean update(Query query,Update update,String collectionName);

	boolean updateByKey(Query query, Update update, String collectionName);

	<T> T findByKey(Class<?> clazz, Criteria criteria,String collectionName);

	<T> List<T> findAll(Class<T> clazz,String collectionName);

}
