package com.cts.onlinedonation.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="This is the User Model")
@Entity
@Table(name="Users")
public class User {

	@ApiModelProperty(value="A unique key for each User")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="u_Id")
	private Integer userId;
	@ApiModelProperty(value="First name for User")
	@Column(name="firstName")
	private String firstName;
	@ApiModelProperty(value="Last name for User")
	@Column(name="lastName")
	private String lastName;
	@ApiModelProperty(value="User password for User")
	@Column(name="password")
	private String password;
	@ApiModelProperty(value="User email for User")
	@Column(name="email")
	private String email;
	@ApiModelProperty(value="User location for User")
	@Column(name="location")
	private String location;

	public User(){

	}

	public User(Integer userId, String firstName, String lastName, String password, String email, String location) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.location = location;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
}
