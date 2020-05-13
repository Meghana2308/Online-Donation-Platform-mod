package com.cts.async.model;

import java.io.Serializable;
import java.time.LocalTime;

public class Process implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9089911519863129623L;
	public long id;
	public int userId;
	public int requestId;
	public int quantity;
	public String date;
	public LocalTime time;
	public Process() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Process(long id, int userId, int requestId, int quantity, String date, LocalTime time) {
		super();
		this.id = id;
		this.userId = userId;
		this.requestId = requestId;
		this.quantity = quantity;
		this.date = date;
		this.time = time;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Process [id=" + id + ", userId=" + userId + ", requestId=" + requestId + ", quantity=" + quantity
				+ ", date=" + date + ", time=" + time + "]";
	}
	
	
	
}