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
 * @date 2021/9/17 8:38
 */
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static{

            try{
                String rec="mybatis-config.xml";
                InputStream inputStream= Resources.getResourceAsStream(rec);
                sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
            }catch (IOException e){
                e.printStackTrace();
            }

        }

        public static SqlSession getSqlSession(){
            return sqlSessionFactory.openSession(true);
        }

}
