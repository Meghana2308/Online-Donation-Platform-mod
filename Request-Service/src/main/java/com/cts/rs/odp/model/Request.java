package com.cts.rs.odp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="This is the Request Model")
@Entity
@Table(name="Request")
public class Request {
	@Id
	@GeneratedValue
	@ApiModelProperty(value="Product name for request")
	@Column(name="request_id")
	private int requestId;
	@Column(name="user_id")
	private int userId;
	@Column(name="product_name")
	private String productName;
	@ApiModelProperty(value="Quantity  for  each Request")
	@Column(name="quantity")
	private long quantity;
	@Column(name="date")
	private String date;

	public Request() {
		
	}
	public Request(int requestId,int userId, String productName, long quantity, String date) {
		super();
		
		this.requestId = requestId;
		this.userId=userId;
		this.productName = productName;
		this.quantity = quantity;
		this.date=date;
		
	}
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId =userId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Request(String date) {
		this.date = date;
	}


}
