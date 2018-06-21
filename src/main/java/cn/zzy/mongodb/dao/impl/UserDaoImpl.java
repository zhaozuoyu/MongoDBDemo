package cn.zzy.mongodb.dao.impl;

import cn.zzy.mongodb.dao.UserDao;
import cn.zzy.mongodb.pojo.User;
import cn.zzy.mongodb.service.UserService;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static Logger log = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public boolean save(Object obj, String collectionName) {
        boolean flag = true;
        try {
            mongoTemplate.save(obj, collectionName);
        } catch (Exception e) {
            flag = false;
            log.error(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public boolean saveOrUpdate(Object obj, String collectionName) {
        return false;
    }

    @Override
    public boolean remove(Object obj, String collectionName) {
        boolean flag = true;
        try {
            mongoTemplate.remove(obj, collectionName);
        } catch (Exception e) {
            flag = false;
            log.error(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public boolean removeByKey(Query query, String collectionName) {
        boolean flag = true;
        try {
            mongoTemplate.remove(query, collectionName);
        } catch (Exception e) {
            flag = false;
            log.error(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public boolean removeByKey(Class<?> clazz, Query query, String collectionName) {
        boolean flag = true;
        try {
            mongoTemplate.remove(query, clazz, collectionName);
        } catch (Exception e) {
            flag = false;
            log.error(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public boolean removeAll(String collectionName) {
        boolean flag = true;
        try {

        } catch (Exception e) {
            flag = false;
            log.error(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public boolean update(Query query, Update update, String collectionName) {
        boolean flag = true;
        try {
            mongoTemplate.updateMulti(query,update,collectionName);
        } catch (Exception e) {
            flag = false;
            log.error(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public boolean updateByKey(Query query, Update update, String collectionName) {
        boolean flag = true;
        try {
            mongoTemplate.updateMulti(query,update,collectionName);
        } catch (Exception e) {
            flag = false;
            log.error(e.getMessage(), e);
        }
        return flag;
    }

    @Override
    public <T> T findByKey(Class<?> clazz, Criteria criteria, String collectionName) {
        T t;
        Query query = new Query();
        query.addCriteria(criteria);
        t = (T) mongoTemplate.find(query, clazz, collectionName);
        return t;
    }

    @Override
    public <T> List<T> findAll(Class<T> clazz, String collectionName) {
        List<T> t;
        t = mongoTemplate.findAll(clazz, collectionName);
        return t;
    }

}
