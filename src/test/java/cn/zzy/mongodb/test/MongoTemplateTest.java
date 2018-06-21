package cn.zzy.mongodb.test;

import cn.zzy.mongodb.dao.UserDao;
import cn.zzy.mongodb.pojo.User;
import cn.zzy.mongodb.service.UserService;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) // 固定写法
@ContextConfiguration("classpath:spring/applicationContext.xml") // 配置文件的路径
public class MongoTemplateTest {

    private static Logger log = Logger.getLogger(MongoTemplateTest.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Test
    public void saveTest() {
        User user = new User("wangermazi", "64564", 38, "逃到地球的人");
        try {
            if (userDao.save(user, "User"))
                log.debug("添加成功！");
            else
                log.debug("添加失败！");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    public void saveOrUpdateTest() {

    }

    @Test
    public void removeTest() {
        User user = new User();
        user.setId(new ObjectId("5b2a20c78ad5d2cc35082667"));
        try {
            if (userDao.remove(user, "User"))
                log.debug("删除成功！");
            else
                log.debug("删除失败！");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    public void removeByKeyTest() {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is("wangermazi"));
        query.addCriteria(Criteria.where("password").is("64564"));
        try {
            if (userDao.removeByKey(query, "User"))
                log.debug("删除成功！");
            else
                log.debug("删除失败！");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    public void updateTest() {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId("5b2a248b8ad51bad3b987cf8")));
        Update update = new Update();
        update.set("password","never");
        try {
            if (userDao.update(query, update, "User"))
                log.debug("修改成功！");
            else
                log.debug("修改失败！");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    public void updateByKeyTest(){
        Update update = new Update();
        update.set("password","hehe");   //set方法用于更新一个字段，若字段不存在则添加
        update.addToSet("passwords","yi");  //addToSet方法用户添加一个数组类型的字段，若数组中含有相同的元素则不向数组中添加
        update.push("test","嘻嘻嘻嘻");   //push方法用于向一个已有的数组末尾添加一个元素，若元素不存在，则会创建一个新的元素
        //update.pop("test",);
        update.pull("","");
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId("5b2a248b8ad51bad3b987cf8")));
        try {
            if (userDao.updateByKey(query, update, "User"))
                log.debug("修改成功！");
            else
                log.debug("修改失败！");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    public void findByKeyTest() {
        try {
            List<User> users = userDao.findByKey(User.class, Criteria.where("username").is("zhaozuoyu"), "User");
            for (User user : users) {
                log.debug(user.getInformation());
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    public void findAll() {
        try {
            List<User> users = userDao.findAll(User.class, "User");
            for (User user : users) {
                log.debug(user.getInformation());
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
