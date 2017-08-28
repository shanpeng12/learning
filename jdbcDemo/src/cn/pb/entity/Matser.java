package cn.pb.entity;

public class Matser {
	private int id;//编号
	private String name;//姓名
	private String password;//密码
	private int money;//元宝数
	public Matser(int id, String name, String password, int money) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.money = money;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String toString() {
		return "Matser [id=" + id + ", name=" + name + ", password=" + password
				+ ", money=" + money + "]";
	}
	
	
}
