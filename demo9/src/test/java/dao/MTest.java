package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MybatisUtils;

import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/19 11:49
 */
public class MTest {

    @Test
    public void queryuserbyid(){

        SqlSession sqlSession= MybatisUtils.getSqlSession();
        User user =sqlSession.getMapper(UserMapper.class).queryUserById(1);
        System.out.println(user);
        System.out.println("______________________________");
        sqlSession.clearCache();//手动清理缓存
        User user2 =sqlSession.getMapper(UserMapper.class).queryUserById(1);
        System.out.println(user2);
        System.out.println("是否相等:"+(user==user2));
        sqlSession.close();
    }

    @Test
    public void queryuserbyid2(){

        SqlSession sqlSession= MybatisUtils.getSqlSession();
        SqlSession sqlSession2= MybatisUtils.getSqlSession();
        User user =sqlSession.getMapper(UserMapper.class).queryUserById(1);
        System.out.println(user);
        sqlSession.close();
        System.out.println("______________________________");
        User user2 =sqlSession2.getMapper(UserMapper.class).queryUserById(1);
        System.out.println(user2);
        System.out.println("是否相等:"+(user==user2));
        sqlSession2.close();
    }
}
