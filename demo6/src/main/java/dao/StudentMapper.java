package dao;

import pojo.Student;

import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/17 8:37
 */
public interface StudentMapper {

    //查询所有的学生信息,以及对应的老师的信息
    public List<Student> getStudent();
    public List<Student> getStudent2();
}
