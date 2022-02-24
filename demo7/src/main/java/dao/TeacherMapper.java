package dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Teacher;

import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/17 8:38
 */
public interface TeacherMapper {

    //获取老师
    List<Teacher> getTeacher();

    //获取指定老师下的所有学生及其老师的信息
    Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher2(@Param("tid") int id);
}
