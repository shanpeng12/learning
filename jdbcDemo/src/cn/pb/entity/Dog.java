package cn.pb.entity;

public class Dog {
	private int id;//编号
	private String name;//姓名
	private int health;//健康值
	private int love;//亲密度
	private String strain;//品种
	
	
	public Dog(int id, String name, int health, int love,
			String strain) {
		super();
		this.id = id;
		this.name = name;
		this.health = health;
		this.love = love;
		this.strain = strain;
	}


	public Dog(String name, int health, int love, String strain) {
		this.name = name;
		this.health = health;
		this.love = love;
		this.strain = strain;
	}


	public Dog() {
		// TODO Auto-generated constructor stub
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


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public int getLove() {
		return love;
	}


	public void setLove(int love) {
		this.love = love;
	}


	public String getStrain() {
		return strain;
	}


	public void setStrain(String strain) {
		this.strain = strain;
	}


	//狗狗自白
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", health=" + health
				+ ", love=" + love + ", strain=" + strain + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + health;
		result = prime * result + id;
		result = prime * result + love;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((strain == null) ? 0 : strain.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (health != other.health)
			return false;
		if (id != other.id)
			return false;
		if (love != other.love)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (strain == null) {
			if (other.strain != null)
				return false;
		} else if (!strain.equals(other.strain))
			return false;
		return true;
	}
}
