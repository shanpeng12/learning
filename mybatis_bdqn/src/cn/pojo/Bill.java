package cn.pojo;

import java.io.Serializable;
import java.util.Date;

//账单类
public class Bill implements Serializable{
	private static final long serialVersionUID = -3878483618050542243L;
	private Integer id;//
	private String billCode;// 账单编码
	private String productName;// 商品名称
	private String productDesc;// 商品描述
	private String productUnit;// 商品单位
	private double productCount;// 商品数量
	private double totalPrice;// 商品总额
	private Integer isPayment;// 是否支付（1：未支付 2：已支付）
	private Integer createdBy;// 创建者（userId）
	private Date creationDate;// 创建时间
	private Integer modifyBy;// 更新者（userId）
	private Date datetime;// 更新时间
	private Integer providerId;// 供应商ID
	private String providerName;//供应商名称
	

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Bill() {
	}

	public Bill(Integer id, String billCode, String productName,
			String productDesc, String productUnit, double productCount,
			double totalPrice, Integer isPayment, Integer createdBy,
			Date creationDate, Integer modifyBy, Date datetime,
			Integer providerId) {
		this.id = id;
		this.billCode = billCode;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productUnit = productUnit;
		this.productCount = productCount;
		this.totalPrice = totalPrice;
		this.isPayment = isPayment;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.datetime = datetime;
		this.providerId = providerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public double getProductCount() {
		return productCount;
	}

	public void setProductCount(double productCount) {
		this.productCount = productCount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getIsPayment() {
		return isPayment;
	}

	public void setIsPayment(Integer isPayment) {
		this.isPayment = isPayment;
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

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", billCode=" + billCode + ", productName="
				+ productName + ", productDesc=" + productDesc
				+ ", productUnit=" + productUnit + ", productCount="
				+ productCount + ", totalPrice=" + totalPrice + ", isPayment="
				+ isPayment + ", createdBy=" + createdBy + ", creationDate="
				+ creationDate + ", modifyBy=" + modifyBy + ", datetime="
				+ datetime + ", providerId=" + providerId + ", providerName="
				+ providerName + "]";
	}
	// id bigint(20)
	// billCode varchar(20)
	// productName varchar(20)
	// productDesc varchar(50)
	// productUnit varchar(10)
	// productCount decimal(20,2)
	// totalPrice decimal(20,2)
	// isPayment int(10)
	// createdBy bigint(20)
	// creationDate datetime
	// modifyBy bigint(20)
	// modifyDate datetime
	// providerId int(20)
}
