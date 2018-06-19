package cn.zzy.mongodb.dao.impl;

import cn.zzy.mongodb.dao.UserDao;
import cn.zzy.mongodb.pojo.User;
import cn.zzy.mongodb.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User findByUserCode(String userCode) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.where("_id").equals(new ObjectId("5b28b3564483cff6b6366e80"));
        query.addCriteria(criteria);
        List<User> users = mongoTemplate.find(query, User.class);
        return users!=null?users.get(0):null;
    }

    @Override
    public List<User> queryAll() {
        return mongoTemplate.findAll(User.class,"User");
    }
}
