package cn.pb.dao;

public interface MasterDaoImp {

	// 1銆佹煡璇㈣幏寰楁墍鏈夌殑鏁版嵁
	public abstract void getAll();

	public abstract void login();

	//避免sql注入使用预处理sql方法
	public abstract void loginsafe();

}