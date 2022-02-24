package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/12 15:54
 */
public interface UserMapper {

    //查询全部用户
    List<User> getUserList();

    //根据Id查询用户
    User getUserById(int id);

    //增加一个用户
    int addUser(User user);

    //修改用户信息
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    //使用Map来增加用户信息
    int addUser2(Map map);
}
