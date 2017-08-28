package cn.dao.provider;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.pojo.Provider;

public interface ProviderMapper {
	//1、获得所有供应商个数
	int count();
	//2、获得所有的供应商
	List<Provider> getAll();
	//3、增加供应商
	int addProvider(Provider p);
	//4、使用注解传递多个参数传入多个参数修改
	int updateByParams(@Param("id") Integer id,@Param("pname")String pname,@Param("pcode")String pcode);
}
