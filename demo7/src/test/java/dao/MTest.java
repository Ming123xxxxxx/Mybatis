package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Student;
import pojo.Teacher;
import utils.MybatisUtils;

import java.io.InputStream;
import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/17 16:45
 */
public class MTest {

    @Test
    public void t1(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        Teacher teacher= sqlSession.getMapper(TeacherMapper.class).getTeacher(1);
            System.out.println(teacher);

    }

    @Test
    public void t2(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        Teacher teacher= sqlSession.getMapper(TeacherMapper.class).getTeacher2(1);
        System.out.println(teacher);

    }
}
