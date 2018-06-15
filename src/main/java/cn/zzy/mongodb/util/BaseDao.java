package cn.zzy.mongodb.util;

import com.mongodb.*;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

import java.util.Map;

public class BaseDao {

    private static final String HOST="127.0.0.1";
    private static final String PORT="27017";
    private static final String DATABASENAME="gome";
    private static Mongo mongo;
    private static DB db;

    private static Logger log = Logger.getLogger(BaseDao.class);

    static{
        try {
           mongo = new Mongo(HOST);
           db = mongo.getDB(DATABASENAME);
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }

    /**
     * 用于获取集合（表）
     * @param collectionName
     * @return
     */
    private DBCollection getCollection(String collectionName){
        return db.getCollection(collectionName);
    }

    public boolean save(Map<String,Object> param,String collectionName){
        boolean flag = true;
        DBObject dbObject = new BasicDBObject(param);
        DBCollection collection = this.getCollection(collectionName);
        try {
            collection.insert(dbObject);
        }catch (Exception e){
            flag=false;
            log.error(e.getMessage(),e);
        }
        return flag;
    }

    public boolean delete(Map<String,Object> param,String collectionName){
        boolean flag = true;
        DBObject dbObject = new BasicDBObject(param);
        DBCollection collection = this.getCollection(collectionName);
        try {
            collection.remove(dbObject);
        }catch (Exception e){
            flag=false;
            log.error(e.getMessage(),e);
        }
        return flag;
    }

    public boolean update(DBObject oldObj,DBObject newObj,String collectionName){
        boolean flag = true;
        DBCollection collection = this.getCollection(collectionName);
        try {
            collection.update(oldObj,newObj);
        }catch (Exception e){
            flag=false;
            log.error(e.getMessage(),e);
        }
        return flag;
    }

    public DBObject query(DBObject dbObject,String collectionName){
        DBObject result = this.getCollection(collectionName).findOne(dbObject);
        return result;
    }

    public DBCursor queryAll(String collectionName){
        DBCursor cursor =null;
        cursor = this.getCollection(collectionName).find();
        return cursor;
    }

    public DBCursor queryWhere(String collectionName){
        DBCursor cursor =null;
        cursor = this.getCollection(collectionName).find();
        return cursor;
    }








}
