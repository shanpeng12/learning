package cn.pb.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.pb.entity.Dog;

import com.mysql.jdbc.Driver;


public class JDBCDemo {
	public static void main(String[] args) {
		//加载驱动
		Driver dr=null;
		Connection ct=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			dr=new Driver();
			DriverManager.registerDriver(dr);
			//获得连接
			try {
				ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbctest", 
						"root", "123");
				System.out.println("连接成功");
			} catch (SQLException e) {
				System.out.println("连接失败");
			}
			//处理sql，获得数据
			st=ct.createStatement();
			String sql="select * from dog";
			rs=st.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int health=rs.getInt("health");
				int love=rs.getInt("love");
				String strain=rs.getString("strain");
				Dog dog=new Dog(id,name,health,love,strain);
				System.out.println(dog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
