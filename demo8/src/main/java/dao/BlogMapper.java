package dao;

import pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author 温黎明0
 * @version 1.0
 * @date 2021/9/18 9:11
 */
public interface BlogMapper {

    //插入数据
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);

    //使用Choose(when otherwise)来查询信息
    List<Blog> queryBlogChoose(Map map);

    //修改信息
    int updateBlog(Map map);

    //查询第1-2-3号记录的博客
    List<Blog> queryForeach(Map map);
}
