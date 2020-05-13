package com.cts.rs.odp.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Process {
        @Id
        @GeneratedValue
        private long id;
        private int userId;
        private int requestId;
        private int quantity;
        private String date;
        private LocalTime time;
        @ManyToOne
        public Request request;

    public Process() {
    }

	public Process( long id ,int userId, int requestId, int quantity, String date, LocalTime time) {
		super();
		
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


    
}
