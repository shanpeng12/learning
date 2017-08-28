package cn.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.pojo.User;

public interface UserMapper {
	//1、获得所有供应商个数
	int count();
	//2、获得所有的供应商
	List<User> getAll();
	//3、模糊查询
	List<User> getByName(String name);
	//4、根据用户名和角色进行模糊查询
	List<User> getUserList(User u);
	//5、根据用户名和角色进行模糊查询以map为新参
	List<User> getUserByMap(Map<String, Object> p);
	//6、根据用户名和角色进行模糊查询以map为新参
	List<User> getUsers(Map<String, Object> p);
	//7、根据用户名和角色进行模糊查询以map为新参,结果集类型为map
	List<User> getUserUseResultMap(Map<String, Object> p);
	//8、增加用户
	int add(User u);
	//9、修改用户信息
	int modify(User u);
	//10、删除用户
	int delect(User u);
	//11、传入多个参数修改
	int updateByparams(@Param("pass")String pass,@Param("id")Integer id);
	//12、根据用户角色查询
	List<User> getUserByRole(Integer role);
	//13、getUserById 
	List<User> getUserById(@Param("id")Integer id);
	
}
