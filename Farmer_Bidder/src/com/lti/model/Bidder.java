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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column( unique=true)
	private int bidderId;
	@Column
	@NotEmpty(message = "Name cannot be empty!")
	private String bidderName;
	
	@Column
	@NotEmpty(message = "Phone Number cannot be empty!")
	@Size(max=10, min=10, message="Phone Number Should be 10 number long" )
	private String phoneNumber;
	
	@Column
	@NotEmpty(message = "UserName cannot be empty!")
	private String email;
	
	@Column
	@Size(min = 8, 
	message = " Password must be atleast 8 Characters Long")
	private String password;
	

	


	

	public Bidder(String bidderName, String phoneNumber, String email, String password,
			BankDetails bankDetails, Address address, DocumentDetails documentDetails) {
		super();

		this.bidderName = bidderName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.bankDetails = bankDetails;
		this.address = address;
		this.documentDetails = documentDetails;
	}

	@OneToOne(cascade=CascadeType.ALL)
	private BankDetails bankDetails;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@OneToOne(cascade=CascadeType.ALL)
	private DocumentDetails documentDetails;
		
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

	

	@Override
	public String toString() {
		return "Bidder [bidderId=" + bidderId + ", bidderName=" + bidderName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", password=" + password + ", bankDetails=" + bankDetails + ", address="
				+ address + ", documentDetails=" + documentDetails + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
