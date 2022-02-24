package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Blog;
import utils.IDUtils;
import utils.MybatisUtils;

import java.util.*;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/18 9:28
 */
public class MTest {

    public void t1(Blog blog){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        int p=sqlSession.getMapper(BlogMapper.class).addBlog(blog);
        if(p>0)
            System.out.println(blog.getTitle()+"添加成功");
        sqlSession.close();
    }

    @Test
    public void add2(){
        Blog blog=new Blog(IDUtils.getId(),"成为架构师","明",new Date(),9999);
        t1(blog);
        blog.setId(IDUtils.getId());
        blog.setTitle("java进阶");
        t1(blog);
        blog.setId(IDUtils.getId());
        blog.setTitle("java入门");
        t1(blog);
        blog.setId(IDUtils.getId());
        blog.setTitle("数据结构与算法");
        t1(blog);

    }


    @Test
    public void qeuryB(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        Map map=new HashMap();
        map.put("title","通往架构师之路");
        map.put("author","明");
        List<Blog> blogList=sqlSession.getMapper(BlogMapper.class).queryBlogIF(map);
        for(Blog blog:blogList){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void qeuryBL(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        Map map=new HashMap();
        map.put("title","成为架构师");
        map.put("author","明");
        map.put("views",9999);
        List<Blog> blogList=sqlSession.getMapper(BlogMapper.class).queryBlogChoose(map);
        for(Blog blog:blogList){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateB(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        Map map=new HashMap();
        map.put("title","通往架构师之路");
        map.put("author","明");
        map.put("id","491d4c15167447698f5dafd47b8baad2");
        int p=sqlSession.getMapper(BlogMapper.class).updateBlog(map);

        if(p>0)
            System.out.println(map.get("title")+"修改成功");
        sqlSession.close();
    }

    @Test
    public void queryC(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        List<Integer> ids=new ArrayList();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        Map map=new HashMap();
        map.put("ids",ids);
        List<Blog> blogList=sqlSession.getMapper(BlogMapper.class).queryForeach(map);

        for(Blog blog:blogList){
            System.out.println(blog);
        }

        sqlSession.close();

    }
}
