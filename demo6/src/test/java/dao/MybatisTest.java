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
 * @date 2021/9/17 9:16
 */
public class MybatisTest {

    @Test
    public void t1(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        TeacherMapper mapper =sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher =mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void t2(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        StudentMapper mapper =sqlSession.getMapper(StudentMapper.class);
        List<Student> list =mapper.getStudent2();
        for(Student student:list) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
