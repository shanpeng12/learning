package cn.dao.bill;

import java.util.List;
import java.util.Map;

import cn.pojo.Bill;

public interface BillMapper {
	//1、根据商品的名称和供应商和是否付过款查询
	List<Bill> getByBills(Map<String, Object> p);
}
