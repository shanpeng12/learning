package cn.pojo;

import java.util.Date;

public class Role {
	private Integer id;
	private String roleCode;
	private String roleName;
	private Integer createdBy;
	private Date creationDate;
	private Integer modifyBy;
	private Date datetime;
	public Role(){}
	public Role(Integer id, String roleCode, String roleName,
			Integer createdBy, Date creationDate, Integer modifyBy,
			Date datetime) {
		this.id = id;
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.datetime = datetime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleCode=" + roleCode + ", roleName="
				+ roleName + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", modifyBy=" + modifyBy + ", datetime="
				+ datetime + "]";
	}
	
	
//	id	bigint(20)
//	roleCode	varchar(15)
//	roleName	varchar(15)
//	createdBy	bigint(20)
//	creationDate	datetime
//	modifyBy	bigint(20)
//	modifyDate	datetime
}
