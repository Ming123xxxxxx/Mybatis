package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import pojo.User;
import utils.UserMapperUtils;

import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/16 14:48
 */
public class UserTest {

    //查询所有用户信息
    @Test
    public void te(){
        SqlSession sqlSession= UserMapperUtils.getSqlSession();
        try{
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            List<User> liseuser =mapper.getUser();
            for(User user:liseuser){
                System.out.println(user);
            }
        }finally {
            sqlSession.close();
        }
    }

    //按id和name查询用户
    @Test
    public void te1(){
        SqlSession sqlSession= UserMapperUtils.getSqlSession();
        try{
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            User user =mapper.getUserBy(2,"张三");
            System.out.println(user);
        }finally {
            sqlSession.close();
        }
    }

    //增加用户信息
    @Test
    public void te2(){
        SqlSession sqlSession= UserMapperUtils.getSqlSession();
        try{
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            int p=mapper.addUser(new User(7,"鲁智深","lzs2131"));
            sqlSession.commit();
            if(p>0)
            System.out.println("添加成功");
        }finally {
            sqlSession.close();
        }
    }

    //修改用户信息
    @Test
    public void te3(){
        SqlSession sqlSession= UserMapperUtils.getSqlSession();
        try{
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            int p=mapper.updateUser(new User(7,"鲁智深","2131lzs"));
            sqlSession.commit();
            if(p>0)
                System.out.println("修改用户信息");
        }finally {
            sqlSession.close();
        }
    }

    //删除用户信息
    @Test
    public void te4(){
        SqlSession sqlSession= UserMapperUtils.getSqlSession();
        try{
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            int p=mapper.deleteUser(7);
            sqlSession.commit();
            if(p>0)
                System.out.println("删除用户信息");
        }finally {
            sqlSession.close();
        }
    }
}
