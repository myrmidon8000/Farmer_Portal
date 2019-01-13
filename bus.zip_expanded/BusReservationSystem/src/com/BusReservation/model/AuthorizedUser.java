package com.BusReservation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class AuthorizedUser {		//POJO for registered/authorized users
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;	

	private String firstname;
	private String lastname;
	private int phoneNumber;						
	private String userEmail;			
	private String Gender;	

	@ColumnDefault("2000.0")
	private float wallet;														
	
	@ManyToOne
	private AuthorizationDetails authorizationDetails;			//object of authorizationdetails to include uname & pwd
	
	public AuthorizedUser() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}


	public float getWallet() {
		return wallet;
	}

	public void setWallet(float wallet) {
		this.wallet = wallet;
	}

	public AuthorizationDetails getAuthorizationDetails() {
		return authorizationDetails;
	}

	public void setAuthorizationDetails(AuthorizationDetails authorizationDetails) {
		this.authorizationDetails = authorizationDetails;
	}

	public AuthorizedUser(String firstname, String lastname, int phoneNumber, String userEmail, String gender,
			String password, float wallet, AuthorizationDetails authorizationDetails) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.userEmail = userEmail;
		Gender = gender;
		this.wallet = wallet;
		this.authorizationDetails = authorizationDetails;
	}

	@Override
	public String toString() {
		return "AuthorizedUser [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", phoneNumber=" + phoneNumber + ", userEmail=" + userEmail + ", Gender=" + Gender +  ", wallet=" + wallet + ", authorizationDetails=" + authorizationDetails + "]";
	}

	
}
