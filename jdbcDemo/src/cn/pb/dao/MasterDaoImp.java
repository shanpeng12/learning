package cn.pb.dao;

public interface MasterDaoImp {

	// 1、查询获得所有的数据
	public abstract void getAll();

	public abstract void login();

	//����sqlע��ʹ��Ԥ����sql����
	public abstract void loginsafe();

}