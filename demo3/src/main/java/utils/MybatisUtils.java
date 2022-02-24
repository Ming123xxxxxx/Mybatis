package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/12 15:32
 */

//工具类
//sqlSessionFactory --> sqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    //使用Mybatis的第一步:获取sqlSessionFactory对象
    static{

        try{

            String resourse="mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resourse);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    //通过第一步有了sqlSessionFactory，因此可以从中获得SqlSession的实例
    //SqlSession完全包含了面向数据库执行SQL命令所需的所有方法

    public static SqlSession getsqlsession(){
        return  sqlSessionFactory.openSession();
    }


}
