package cn.pb.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Util;

public class util {
	Connection ct=null;
	Statement st=null;
	ResultSet rt=null;
	//1、创建连接
	public Connection getConnection(String url,String user,String password){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ct=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}
	//2、获得Statement对象
	public Statement getStatement(Connection ct){
		try {
			st=ct.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
	//、获得结果集
	public ResultSet getRseultSet(String sql,Statement st){	
		try {
			rt=st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rt;
	}
	//关闭资源
	public void closeRouser(Connection ct,Statement st,ResultSet rt){
			try {
				if(rt!=null){
				rt.close();
				}
				if(st!=null){
					st.close();
				}
				if(ct!=null){
					ct.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	//获得配置文件信息
	public static void getProper(){
		Properties pt=new Properties();//创建对象
		String path="databas.properties";
		InputStream io=Util.class.getClassLoader().getResourceAsStream(path);
		try {
			pt.load(io);
			String driver=pt.getProperty("jdbc.driver.class");
			String url=pt.getProperty("jdbc.connection.url");
			String name=pt.getProperty("jdbc.connection.username");
			String pass=pt.getProperty("jdbc.connection.password");
			System.out.println("驱动："+driver);
			System.out.println("地址："+url);
			System.out.println("用户名："+name);
			System.out.println("密码："+pass);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		getProper();
	}
	
}
