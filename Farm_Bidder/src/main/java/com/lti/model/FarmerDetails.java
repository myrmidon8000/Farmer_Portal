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
public class FarmerDetails implements Serializable {

	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="farmerdetails_sequence")
	@SequenceGenerator(name="farmerdetails_sequence",sequenceName="farmerdetails_sequence")
	@Column
private int farmerDetailsId;
@Id
@Column
@NotEmpty(message = "Phone Number cannot be empty!")
@Size(max=10, min=10, message="Phone Number Should be 10 number long" )
private int phoneNumber;
@OneToOne(cascade=CascadeType.ALL)
private BankDetails bankDetails;
@OneToOne(cascade=CascadeType.ALL)
private Address address;
@OneToOne(cascade=CascadeType.ALL)
private LandDetails landDetails;
@OneToOne(cascade=CascadeType.ALL)
private DocumentDetails documentDetails;
public int getFarmerDetailsId() {
	return farmerDetailsId;
}
public void setFarmerDetailsId(int farmerDetailsId) {
	this.farmerDetailsId = farmerDetailsId;
}
public int getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(int phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public BankDetails getBankDetails() {
	return bankDetails;
}
public Address getAddress() {
	return address;
}
public LandDetails getLandDetails() {
	return landDetails;
}

public DocumentDetails getDocumentDetails() {
	return documentDetails;
}

@Override
public String toString() {
	return "FarmerDetails [farmerDetailsId=" + farmerDetailsId + ", phoneNumber=" + phoneNumber + ", bankDetails="
			+ bankDetails + ", address=" + address + ", landDetails=" + landDetails + ", documentDetails="
			+ documentDetails + "]";
}
public FarmerDetails(int phoneNumber,BankDetails bankDetails, Address address, LandDetails landDetails,DocumentDetails documentDetails ) {
	super();
	
	this.phoneNumber = phoneNumber;
	this.bankDetails=bankDetails;
	this.address=address;
	this.landDetails=landDetails;
	this.documentDetails=documentDetails ;
}
public FarmerDetails() {
	super();
	// TODO Auto-generated constructor stub
}

}
