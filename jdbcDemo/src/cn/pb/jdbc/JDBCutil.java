package cn.pb.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.pb.dao.util;
import cn.pb.entity.Dog;

public class JDBCutil {

	public static void main(String[] args) {
		util u=new util();
		String url="jdbc:mysql://127.0.0.1:3306/jdbctest";
		String user="root",password="123";
		Connection ct=u.getConnection(url, user, password);
		Statement st=null;
		ResultSet rt=null;
		try {
			st=u.getStatement(ct);
			String sql="select * from dog;";
			rt=st.executeQuery(sql);
			while(rt.next()){
				int id=rt.getInt("id");
				String name=rt.getString("name");
				int health=rt.getInt("health");
				int love=rt.getInt("love");
				String strain=rt.getString("strain");
				Dog dog=new Dog(id,name,health,love,strain);
				System.out.println(dog);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			u.closeRouser(ct, st, rt);
		}

	}

}
