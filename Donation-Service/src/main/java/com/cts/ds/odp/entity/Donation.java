package com.cts.ds.odp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="This is the Donation Model")
	@Entity
	@Table(name="Donation")


	public class Donation {
		@ApiModelProperty(value="A unique key for each Donation")
		@Id
		@GeneratedValue
		@Column(name="Donation_id")
		public int donationId;
		@ApiModelProperty(value="Product name for Donation")
		@Column(name="Product_name")
		public String productName;
		@ApiModelProperty(value="Quantity  for  each Donation")
		@Column(name="Quantity")
		public int quantity;
		@ApiModelProperty(value="Location  for Donation")
		@Column(name="Location")
		public String location;
		@ApiModelProperty(value="Date of Donation")
		@JsonFormat(pattern="yyy-MM-dd",shape=Shape.STRING)
		@Column(name="Date")
		public String  date;
		@ApiModelProperty(value="UserId of Donation")
		@Column(name="user_id")
		public int userId;

		
		

			public Donation() {
			super();
		}



			public Donation(int donationId, String productName, int quantity, String location, String date, int userId) {
				super();
				this.donationId = donationId;
				this.productName = productName;
				this.quantity = quantity;
				this.location = location;
				this.date = date;
				this.userId = userId;
			}



			public int getDonationId() {
				return donationId;
			}



			public void setDonationId(int donationId) {
				this.donationId = donationId;
			}



			public String getProductName() {
				return productName;
			}



			public void setProductName(String productName) {
				this.productName = productName;
			}



			public int getQuantity() {
				return quantity;
			}



			public void setQuantity(int quantity) {
				this.quantity = quantity;
			}



			public String getLocation() {
				return location;
			}

}
