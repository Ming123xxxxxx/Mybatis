package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/12 16:15
 */
public class UserDaoTest {

    //查询所有用户信息
    @Test
    public void test(){
        //1.获得SqlSession对象
        SqlSession sqlSession= MybatisUtils.getsqlsession();;
       try{
           //2.执行SQL
           UserMapper mapper = sqlSession.getMapper(UserMapper.class);
           List<User> userList = mapper.getUserList();

           for (User user : userList) {
               System.out.println(user);
           }
       }finally {
           //关闭SqlSession
           sqlSession.close();
       }

    }

    //按id查询用户信息
    @Test
    public void getUserById(){

        //1.获得SqlSession对象
        SqlSession sqlSession=MybatisUtils.getsqlsession();;
        try{
            //2.执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User userById=mapper.getUserById(1);

            System.out.println(userById);
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }

    }

    //增加一个用户
    @Test
    public void addUser(){

        //1.获得SqlSession对象
        SqlSession sqlSession=MybatisUtils.getsqlsession();;
        try{
            //2.执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int num=mapper.addUser(new User(6,"典韦","132aaa"));

            //提交事务
            sqlSession.commit();
            if(num>0) {
                System.out.println("添加成功");
            }
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }

    }

    //修改用户信息
    @Test
    public void updateUser(){

        //1.获得SqlSession对象
        SqlSession sqlSession=MybatisUtils.getsqlsession();;
        try{
            //2.执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int num=mapper.updateUser(new User(4,"后裔","3aaaa"));

            //提交事务
            sqlSession.commit();
            if(num>0) {
                System.out.println("修改成功");
            }
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }

    }

    //删除用户信息
    @Test
    public void deleteuser(){

        //1.获得SqlSession对象
        SqlSession sqlSession=MybatisUtils.getsqlsession();;
        try{
            //2.执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int num=mapper.deleteUser(4);

            //提交事务
            sqlSession.commit();
            if(num>0) {
                System.out.println("删除成功");
            }
        }finally {
            //关闭SqlSession
            sqlSession.close();
        }

    }


}
