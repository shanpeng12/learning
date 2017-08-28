package cn.dao.provider;



import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.ibatis.session.SqlSession;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.dao.user.TestUser;
import cn.pojo.Provider;
import cn.util.MybatisUtil;

public class TestProvider extends HttpServlet {
	private static final long serialVersionUID = -6754618384532208717L;
	private Logger log=Logger.getLogger(TestUser.class);
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void test() {
		SqlSession sqlSession=MybatisUtil.createSqlSession();
		//1.定义资源
		try {
			int count=sqlSession.getMapper(ProviderMapper.class).count();
			log.debug("TestProvidercount="+count);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
	}
	public List<Provider> Test1(){
		SqlSession sqlSession=MybatisUtil.createSqlSession();

		List<Provider> list=null;
		try {

			list=sqlSession.getMapper(ProviderMapper.class).getAll();
			if(list!=null){
				for(Provider p:list){
					log.debug("ProCode="+p.getProCode()+"   ProName="+p.getProName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
		return list;
	}
	@Test
	public void addProvider() {
		SqlSession sqlSession=MybatisUtil.createSqlSession();
		//1.定义资源
		try {
			Provider p=new Provider();
			p.setProCode("BJ_G23H00");
			p.setProName("安徽三河产业");
			p.setProDesc("1234");
			p.setProContact("张三");
			p.setProPhone("13866666666");
			p.setProAddress("安徽合肥市包河区");
			p.setProFax("0551-34452321");
			p.setCreatedBy(1);
			p.setCreationDate(new Date());
			int i=sqlSession.getMapper(ProviderMapper.class).addProvider(p);
			if(i>0){
				sqlSession.commit();
				log.debug("添加成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
	}
	@Test
	public void updateByParams() {
		SqlSession sqlSession=MybatisUtil.createSqlSession();
		//1.定义资源
		try {
//			Provider p=new Provider();
//			p.setProCode("BJ_G23H00");
//			p.setProName("安徽三河产业");
//			p.setProDesc("1234");
//			p.setProContact("张三");
//			p.setProPhone("13866666666");
//			p.setProAddress("安徽合肥市包河区");
//			p.setProFax("0551-34452321");
//			p.setCreatedBy(1);
//			p.setCreationDate(new Date());
			int i=sqlSession.getMapper(ProviderMapper.class).updateByParams(16, "合肥", "123445");
			if(i>0){
				sqlSession.commit();
				log.debug("修改成功");
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getServletPath();// 获得servlet请求路径
		System.out.println(path);/* 如：/doregister.do */
		int index = path.lastIndexOf(".");// 获得最后一个点的位置
		path = path.substring(1, index); // doregister
		if (path != null && !"".equals(path)) {
			try {
				// 通过反射机制调用方法对应的方法
				Method m = this.getClass().getDeclaredMethod(path, HttpServletRequest.class, HttpServletResponse.class);
				// MainServlet对象调用自己的path()方法
				m.invoke(this, request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Provider> list = Test1();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String json = JSON.toJSONString(list);
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
}
