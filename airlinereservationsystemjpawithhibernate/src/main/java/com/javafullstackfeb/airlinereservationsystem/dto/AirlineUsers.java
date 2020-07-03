package com.javafullstackfeb.airlinereservationsystem.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.javafullstackfeb.airlinereservationsystem.dto.AirlineUsers;

import lombok.Data;
import lombok.ToString;

@SuppressWarnings("serial")

@Data
@Entity
@Table(name="airline_users")
public class AirlineUsers implements Serializable{
	
	  	@Id
	  	@Column
		private int id;
	  	@Column
		private String name;
		@Column(name="email_id")
		private String emailId;
		@ToString.Exclude
		@Column
		private String password;
		@Column(name="mobile_no")
		private long mobileNo;
		@Column
		private String role;

	}
