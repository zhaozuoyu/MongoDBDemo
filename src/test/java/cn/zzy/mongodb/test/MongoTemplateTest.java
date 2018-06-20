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
        //User user = new User();
        //user.setId(new ObjectId("5b2a248b8ad51bad3b987cf8"));
        List<User> users = userDao.findByKey(User.class,Criteria.where("_id").is(new ObjectId("5b2a248b8ad51bad3b987cf8")), "User");
        User user = users.get(0);
        Update update = new Update();
        update.set("password","never");
        //update.addToSet("password","never");
        try {
            if (userDao.update(user, update, "User"))
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
