package com.lti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.Size;
import org.springframework.stereotype.Component;

@Component
@Entity

public class Bidder implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bidder_sequence")
	@SequenceGenerator(name="bidder_sequence",sequenceName="bidder_sequence")
	@Column
	private int bidderId;
	@Column
	@NotEmpty(message = "Name cannot be empty!")
	private String bidderName;
	
	@Column
	@NotEmpty(message = "Phone Number cannot be empty!")
	@Size(max=10, min=10, message="Phone Number Should be 10 number long" )
	private String phoneNumber;
	
	@OneToOne(cascade=CascadeType.ALL)
	private BankDetails bankDetails;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@OneToOne(cascade=CascadeType.ALL)
	private DocumentDetails documentDetails;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Login login;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	

	public int getBidderId() {
		return bidderId;
	}

	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	public String getBidderName() {
		return bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Bidder(String bidderName, String phoneNumber, BankDetails bankDetails, Address address,
			DocumentDetails documentDetails, Login login) {
		super();
		this.bidderName = bidderName;
		this.phoneNumber = phoneNumber;
		this.bankDetails = bankDetails;
		this.address = address;
		this.documentDetails = documentDetails;
		this.login = login;
	}

	@Override
	public String toString() {
		return "Bidder [bidderId=" + bidderId + ", bidderName=" + bidderName + ", phoneNumber=" + phoneNumber
				+ ", bankDetails=" + bankDetails + ", address=" + address + ", documentDetails=" + documentDetails
				+ ", login=" + login + "]";
	}

	public BankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public DocumentDetails getDocumentDetails() {
		return documentDetails;
	}

	public void setDocumentDetails(DocumentDetails documentDetails) {
		this.documentDetails = documentDetails;
	}

	public Bidder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
