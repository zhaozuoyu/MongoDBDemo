package cn.zzy.mongodb.test;

import cn.zzy.mongodb.pojo.User;
import cn.zzy.mongodb.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) // 固定写法
@ContextConfiguration("classpath:spring/applicationContext.xml") // 配置文件的路径
public class MongoTemplateTest {

    private static Logger log = Logger.getLogger(MongoTemplateTest.class);

    @Autowired
    private UserService userService;

    @Test
     public void queryAllTest(){
        try {
            List<User> users = userService.queryAll();
            for (User user:users){
                log.debug(user.getInformation());
            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void findByUserCodeTest(){
        try {
         User user = userService.findByUserCode(null);
            log.debug(user.getInformation());
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }
}
