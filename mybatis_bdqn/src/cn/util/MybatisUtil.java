package cn.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//工具类
public class MybatisUtil {
	//加载资源
	private static SqlSessionFactory factory=null;
	static{
		String resource="mybatis-config.xml";
		try {
			InputStream is=Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获得sqlSession
	public static SqlSession createSqlSession(){
		return factory.openSession(false);//开启事务控制
	}
	//关闭资源
	public static void close(SqlSession s){
		if(s!=null){
			s.close();
		}
	}
}
