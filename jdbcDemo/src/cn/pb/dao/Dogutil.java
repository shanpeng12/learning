package cn.pb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.pb.entity.Dog;

public class Dogutil {
	private String url="jdbc:mysql://127.0.0.1:3306/jdbctest";
	private String user="root";
	private String password="123";
	private util u= new util();
	private Connection ct=u.getConnection(url, user, password);
	public String getSql(){
		String name="当当";
		int love=50;
		int health=90;
		String strain="八哥";
		String sql="insert into dog(name,love,health,strain)"+
		"values ('"+name+"',"+love+","+health+",'"+strain+"')";
		return sql;
	}
	

	public boolean add(){
		Statement st=u.getStatement(ct);
		try {
			st.executeUpdate(getSql());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			u.closeRouser(null, st, null);
		}
		return false;
	}
	public boolean dele(){
		Statement st=u.getStatement(ct);
		ResultSet rt=u.getRseultSet("select * from dog where id=5", st);
		try {
			if(rt.next()){
				st.executeUpdate("delect from dog where id=5");
				return true;
			}else{
				System.out.println("你删除的数据不存在！");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			u.closeRouser(null, st, null);
		}
		return false;
	}
	//查询所有信息
	public void getALL(){
		Statement st=u.getStatement(ct);
		ResultSet rt=null;
		try {
			rt=st.executeQuery("select id,name,love,health,strain from dog");
			while(rt.next()){
				int id=rt.getInt("id");
				String name=rt.getString("name");
				int health=rt.getInt("health");
				int love=rt.getInt("love");
				String strain=rt.getString("strain");
				Dog dog=new Dog(id,name,health,love,strain);
				System.out.println(dog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			u.closeRouser(null, st, rt);
		}
		
	}
	public boolean update(){
		Statement st=u.getStatement(ct);
		ResultSet rt=u.getRseultSet("select * from dog where id=5", st);
		try {
			if(rt.next()){
				st.executeUpdate("update dog set love=100,health=100 where id=5");
				return true;
			}else{
				System.out.println("你修改的数据不存在！");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			u.closeRouser(null, st, null);
		}
		return false;
	}
	//使用preparedStatement想表中添加数据
	public void add2(Dog dog){
		String sql="insert into dog(name,love,health,strain)"+
				"values (?,?,?,?)";
		PreparedStatement pstm=null;
		try {
			pstm=ct.prepareStatement(sql);
			pstm.setString(1, dog.getName());
			pstm.setInt(2, dog.getLove());
			pstm.setInt(3,dog.getHealth());
			pstm.setString(4, dog.getStrain());
			int rt=pstm.executeUpdate();
			if(rt>0){
				System.out.println("添加成功！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstm!=null){
					pstm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Test
	public void testAdd(){
		Dog d1=new Dog("点点",90,70,"藏獒");
		Dog d2=new Dog("小黑",90,70,"土狗");
		add2(d1);
		add2(d2);
		getALL();
	}
}
