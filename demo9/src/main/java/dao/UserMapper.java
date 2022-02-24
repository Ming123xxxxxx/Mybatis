package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/19 11:52
 */
public interface UserMapper {

    User queryUserById(@Param("id") int id);
    int updateUser(User user);
}
