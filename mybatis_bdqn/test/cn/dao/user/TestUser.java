package cn.dao.user;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.ibatis.session.SqlSession;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import cn.pojo.Address;
import cn.pojo.User;
import cn.util.MybatisUtil;

public class TestUser {
	private Logger log=Logger.getLogger(TestUser.class);

	@Before
	public void setUp() throws Exception {
	}
	//1、获得所有供应商个数
	@Test
	public void test() {

		SqlSession sqlSession=null;
		try {

			sqlSession=MybatisUtil.createSqlSession();
			int count=sqlSession.getMapper(UserMapper.class).count();
			log.debug("TestUsercount="+count);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
		
		
	}
	//2、获得所有的供应商
	@Test
	public void Test1(){
		SqlSession sqlSession=null;
		try {

			sqlSession=MybatisUtil.createSqlSession();
			List<User> list=sqlSession.getMapper(UserMapper.class).getAll();
			if(list!=null){
				for(User u:list){
					log.debug("UserName="+u.getUserName()+"UserCode="+u.getUserCode());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
	}
	//3、模糊查询
	@Test
	public void getByName(){
		SqlSession sqlSession=null;
		try {

			sqlSession=MybatisUtil.createSqlSession();
			List<User> list=sqlSession.getMapper(UserMapper.class).getByName("赵");
			if(list!=null){
				for(User u:list){
					log.debug("UserName="+u.getUserName()+"UserCode="+u.getUserCode());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
	}
	//4、根据用户名和角色进行模糊查询
	@Test
	public void getUserList(){
		SqlSession sqlSession=null;
		try {

			sqlSession=MybatisUtil.createSqlSession();
			User user=new User();
			user.setUserName("赵");
			user.setUserRole(2);
			List<User> list=sqlSession.getMapper(UserMapper.class).getUserList(user);
			if(list!=null){
				for(User u:list){
					log.debug(u.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
	}
	//5、根据用户名和角色进行模糊查询yimap为新参
	@Test
	public void getUserByMap(){
		SqlSession sqlSession=null;
		try {

			sqlSession=MybatisUtil.createSqlSession();
			Map<String, Object> p=new HashMap<String, Object>();
			p.put("name", "赵");
			p.put("role", 2);
			List<User> list=sqlSession.getMapper(UserMapper.class).getUserByMap(p);
			if(list!=null){
				for(User u:list){
					log.debug(u.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
	}
	//6、根据用户名和角色进行模糊查询yimap为新参
	@Test
	public void getUsers123(){
		SqlSession sqlSession=null;
		try {

			sqlSession=MybatisUtil.createSqlSession();
			Map<String, Object> p=new HashMap<String, Object>();
			p.put("name", "赵");
			p.put("role", 2);
			List<User> list=sqlSession.getMapper(UserMapper.class).getUsers(p);
			if(list!=null){
				for(User u:list){
					log.debug(u.getUserName());
					log.debug(u.getUserRoleName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
	}
	//7、根据用户名和角色进行模糊查询yimap为新参
	@Test
	public void getUserUseResultMap(){
		SqlSession sqlSession=null;
		try {

			sqlSession=MybatisUtil.createSqlSession();
			Map<String, Object> p=new HashMap<String, Object>();
			p.put("name", "赵");
			p.put("role", 2);
			List<User> list=sqlSession.getMapper(UserMapper.class).getUserUseResultMap(p);
			if(list!=null){
				for(User u:list){
					log.debug(u.getUserRoleName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
	}
	//8、增加用户
	
	public void add(){
		SqlSession sqlSession=null;
		try {
			sqlSession=MybatisUtil.createSqlSession();
			User user=new User();
			user.setUserName("李四");
			user.setUserCode("lisi");
			user.setUserPassword("123123");
			int i=sqlSession.getMapper(UserMapper.class).add(user);
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
	//9修改用户信息
	@Test
	public void modify(){
		SqlSession sqlSession=null;
		try {
			sqlSession=MybatisUtil.createSqlSession();
			User user=new User();
			user.setId(18);
			user.setUserName("张三");
			user.setUserCode("zhansan");
			user.setUserPassword("00000000");
			int i=sqlSession.getMapper(UserMapper.class).modify(user);
			if(i>0){
				sqlSession.commit();
				log.debug("修改成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
	}
	//10、删除用户
	@Test
	public void delect(){
		SqlSession sqlSession=null;
		try {
			sqlSession=MybatisUtil.createSqlSession();
			User user=new User();
			user.setId(17);
			int i=sqlSession.getMapper(UserMapper.class).delect(user);
			if(i>0){
				sqlSession.commit();
				log.debug("删除成功");
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
	}
	//11.传入多个参数修改
	@Test
	public void updateByparams(){
		SqlSession sqlSession=null;
		try {
			sqlSession=MybatisUtil.createSqlSession();
			int i=sqlSession.getMapper(UserMapper.class).updateByparams("admin12", 12);
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
	//12、根据用户角色查询
	@Test
	public void getUserByRole(){
		SqlSession sqlSession=null;
		try {

			sqlSession=MybatisUtil.createSqlSession();
			List<User> list=sqlSession.getMapper(UserMapper.class).getUserByRole(2);
			if(list!=null){
				for(User u:list){
					log.debug(u.getUserName());
					log.debug(u.getRole().getRoleName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
	}
	// 13、测试根据用户名进行模糊查询获得用户列表
	@Test
	public void getUserById() {
		SqlSession sqlsession = null;
		try {
			// 1、获得sqlsession
			sqlsession = MybatisUtil.createSqlSession();
			UserMapper u = (UserMapper) sqlsession.getMapper(UserMapper.class);
			// 2、获得结果集
			List<User> list = u.getUserById(1);
			// 3、通过log对控制台输出信息
			for (User user : list) {
				log.debug("User user=" + user.getUserName());
				for (Address a : user.getAddressList()) {
					log.debug("User Address=" + a);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4、关闭资源
			if (sqlsession != null) {
				MybatisUtil.close(sqlsession);
			}
		}
	}
}
