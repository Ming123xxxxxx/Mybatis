package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/15 10:13
 */
public interface UserMapper {

    List<User> queryAll();

    int addUser(User user);

    List<User> getUserLimit(Map<String, Integer> map);

    //使用RowBounds实现分页
    List<User> getUserRowBounds();
}
