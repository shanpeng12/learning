package cn.pb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import cn.pb.entity.Matser;

public class MasterDao implements MasterDaoImp {
	Scanner sc=new Scanner(System.in);
	private String url = "jdbc:mysql://127.0.0.1:3306/jdbctest?unicode@character=utf8";
	private String user = "root";
	private String password = "123";
	private util u = new util();
	private Connection ct = u.getConnection(url, user, password);

	// 1、查询获得所有的数据
	/* (non-Javadoc)
	 * @see cn.pb.dao.MasterDaoImp#getAll()
	 */
	public void getAll() {
		Statement st = u.getStatement(ct);
		ResultSet rt = null;
		try {
			rt = st.executeQuery("select id,name,password,money from master");
			while (rt.next()) {
				int id = rt.getInt("id");
				String name = rt.getString("name");
				String password = rt.getString("password");
				int money = rt.getInt("money");
				Matser m = new Matser(id, name, password, money);
				System.out.println(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			u.closeRouser(null, st, rt);
		}

	}
	/* (non-Javadoc)
	 * @see cn.pb.dao.MasterDaoImp#login()
	 */
	public void login(){
		System.out.println("\t���˵�¼");
		System.out.print("�������û�������");
		String name1=sc.next();
		System.out.print("���������룺");
		String password1=sc.next();
		String sql="select name,password from master where name='"+name1+
				"' and password='"+password1+"';";
		System.out.println(sql);
		Statement st = u.getStatement(ct);
		ResultSet rt=null;
		try {
			rt=st.executeQuery(sql);
			if(rt.next()){
				System.out.println("��¼�ɹ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			u.closeRouser(null, st, rt);
		}
	}
	//����sqlע��ʹ��Ԥ����sql����
	/* (non-Javadoc)
	 * @see cn.pb.dao.MasterDaoImp#loginsafe()
	 */
	public void loginsafe(){
		System.out.println("\t���˵�¼");
		System.out.print("�������û�������");
		String name1=sc.next();
		System.out.print("���������룺");
		String password1=sc.next();
		String sql="select name,password from master where name=? and password=?;";
		PreparedStatement pstm=null;
		ResultSet rt=null;
		try {
			pstm=ct.prepareStatement(sql);
			pstm.setString(1, name1);
			pstm.setString(2, password1);
			rt=pstm.executeQuery();
			if(rt.next()){
				System.out.println("��¼�ɹ�");
			}else{
				System.out.println("�û����������������");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			u.closeRouser(null, null, rt);
		}
	}
	public static void main(String[] args){
		MasterDaoImp md=new MasterDao();
		md.getAll();
		md.loginsafe();
		
	}

}
