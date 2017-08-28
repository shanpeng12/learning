package cn.dao.bill;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import cn.dao.user.TestUser;
import cn.pojo.Bill;
import cn.util.MybatisUtil;

public class BillMapperTest {
	private Logger log=Logger.getLogger(TestUser.class);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getByBills() {

		SqlSession sqlSession=null;
		try {

			sqlSession=MybatisUtil.createSqlSession();
			Map<String, Object> p=new HashMap<String, Object>();
			p.put("pname", "米");
			p.put("pid", 3);
			p.put("ispay", 2);
			List<Bill> list=sqlSession.getMapper(BillMapper.class).getByBills(p);
			for(Bill b:list){
				log.debug(b.getId());
				log.debug(b.getProductName());
				log.debug(b.getProviderName());
				log.debug(b.getTotalPrice());
				log.debug(b.getIsPayment()==2?"已付":"未付");
				log.debug(b.getCreationDate());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MybatisUtil.close(sqlSession);
		}
		
		
	}

}
