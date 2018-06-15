package cn.zzy.mongodb.test;

import cn.zzy.mongodb.util.BaseDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BaseDaoTest {

    private BaseDao baseDao = new BaseDao();

    private static Logger log = Logger.getLogger(BaseDaoTest.class);

    @Test
    public void queryAll(){
        DBCursor cursor = baseDao.queryAll("User");
        DBObject dbObject =null;
        while (cursor.hasNext()){
            dbObject=cursor.next();
            System.out.println(dbObject.toString());
        }
    }

    @Test
    public void save(){
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("username","zhangsan");
        param.put("password","123");
        param.put("age","21");
        param.put("informaion","来自星星的你");
        if(baseDao.save(param,"User")){
            log.debug("添加信息成功！");
        }else{
            log.debug("添加信息失败！");
        }

    }

    @Test
    public void update(){
        try {
            DBObject oldObj = new BasicDBObject("username","zhangsan");
            DBObject newObj = oldObj;
            newObj=baseDao.query(oldObj,"User");
            newObj.put("username","lisi");
            baseDao.update(oldObj,newObj,"User");
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Test
    public void delete(){
        Map<String,Object> param = new HashMap<String,Object>();
        //注意：若这里根据_id删除指定的信息时，需要创建一个ObjectId对象，否则删除信息会失败
        param.put("_id",new ObjectId("5b2374dd8ad565bc0bbbf795"));
        boolean flag = baseDao.delete(param,"User");
        if (flag==true){
            log.debug("删除指定数据成功！");
        }else{
            log.debug("删除指定数据失败！");
        }
    }
}
