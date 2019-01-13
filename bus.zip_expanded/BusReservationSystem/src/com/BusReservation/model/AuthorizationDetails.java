package com.BusReservation.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AuthorizationDetails {		//POJO for storing username password
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int authid;
	private String userName;							
	private String password;							
	
	public AuthorizationDetails() {					
		super();
	}
	
	public AuthorizationDetails(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "AuthorizationDetails [userName=" + userName + ", password=" + password + "]";
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}

	public int getAuthid() {
		return authid;
	}

	public void setAuthid(int authid) {
		this.authid = authid;
	}
	
}
