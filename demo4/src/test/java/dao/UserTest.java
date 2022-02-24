package dao;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.UserMapperUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/15 10:21
 */
public class UserTest {

    static Logger logger=Logger.getLogger(UserTest.class);

    @Test
    public void query(){
        SqlSession sqlSession= UserMapperUtils.getSqlSession();
        try{
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            List<User> list =mapper.queryAll();

            for(User user:list){
                System.out.println(user);
            }
        }finally {
            sqlSession.close();
        }

    }

    @Test
    public void addUser(){
        SqlSession sqlSession= UserMapperUtils.getSqlSession();
        try{
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            int p =mapper.addUser(new User(4,"李逵","lk12adw"));

            sqlSession.commit();
            if(p>0){
                System.out.println("增加成功");
            }


        }finally {
            sqlSession.close();
        }
    }

    //实现分页
    @Test
    public void getuserlimit(){
        SqlSession sqlSession=UserMapperUtils.getSqlSession();
        try{
            UserMapper mapper =sqlSession.getMapper(UserMapper.class);
            HashMap map=new HashMap<String, Integer>();
            map.put("startIndex",2);
            map.put("pageSize",3);
            List<User> list=mapper.getUserLimit(map);
            for(User user : list){
                System.out.println(user);
            }
        }finally {
            sqlSession.close();
        }

    }

    @Test
    public void testLog4j(){
        logger.info("info:////");
        logger.debug("debug://xxx/");
        logger.error("error:****");
    }

    //使用RowBounds实现分页
    @Test
    public void testRowBounds(){
        SqlSession sqlSession= UserMapperUtils.getSqlSession();
        try{
            //RowBounds实现
            RowBounds rowBounds = new RowBounds(0,2);

            //通过java代码层面实现分页
            List<User> userlist = sqlSession.selectList("dao.UserMapper.getUserRowBounds",null,rowBounds);
            for(User user:userlist){
                System.out.println(user);
            }

        }finally {
            sqlSession.close();
        }
    }
}
