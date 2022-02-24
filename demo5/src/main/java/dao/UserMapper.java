package dao;

import org.apache.ibatis.annotations.*;
import pojo.User;

import java.util.List;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/16 14:46
 */
public interface UserMapper {

    //查询所有用户
    @Select("select * from user")
    List<User>  getUser();

    //按id和name查询用户
    //方法存在多个参数,所有的参数前面必须加上@Param("xx")注解
    //sql语句中的id对应@Param注解中的id,而不是参数中的id
    @Select("select * from user where id=#{id} and name=#{name}")
     User getUserBy(@Param("id") int id,@Param("name") String name);

    //增加用户
    @Insert("insert into user values (#{id},#{name},#{pwd})")
     int addUser(User user);

    //修改用户
    @Update("update  user set name=#{name},password=#{pwd} where id=#{id}")
     int updateUser(User user);

    //删除用户信息
    @Delete("delete from user where id =#{id}")
     int deleteUser(int id);
}
