package com.lti.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.Size;
import org.springframework.stereotype.Component;

@Component	
@Entity
public class Farmer implements Serializable  {
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="farmer_sequence")
@SequenceGenerator(name="farmer_sequence",sequenceName="farmer_sequence")
@Column
private int farmerId;
@Column
@NotEmpty(message = "Name cannot be empty!")
private String farmerName;

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

@OneToOne(cascade=CascadeType.ALL)
private BankDetails bankDetails;

@OneToOne(cascade=CascadeType.ALL)
private Address address;

@OneToOne(cascade=CascadeType.ALL)
private LandDetails landDetails;

@OneToOne(cascade=CascadeType.ALL)
private DocumentDetails documentDetails;

public int getFarmerId() {
	return farmerId;
}
public void setFarmerId(int farmerId) {
	this.farmerId = farmerId;
}
public String getFarmerName() {
	return farmerName;
}
public void setFarmerName(String farmerName) {
	this.farmerName = farmerName;
}
public Farmer() {
	super();
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
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
public LandDetails getLandDetails() {
	return landDetails;
}
public void setLandDetails(LandDetails landDetails) {
	this.landDetails = landDetails;
}
public DocumentDetails getDocumentDetails() {
	return documentDetails;
}
public void setDocumentDetails(DocumentDetails documentDetails) {
	this.documentDetails = documentDetails;
}


public Farmer(int farmerId, String farmerName, String phoneNumber, String email, String password,
		BankDetails bankDetails, Address address, LandDetails landDetails, DocumentDetails documentDetails) {
	super();
	this.farmerId = farmerId;
	this.farmerName = farmerName;
	this.phoneNumber = phoneNumber;
	this.email = email;
	this.password = password;
	this.bankDetails = bankDetails;
	this.address = address;
	this.landDetails = landDetails;
	this.documentDetails = documentDetails;
}
@Override
public String toString() {
	return "Farmer [farmerId=" + farmerId + ", farmerName=" + farmerName + ", phoneNumber=" + phoneNumber + ", email="
			+ email + ", password=" + password + ", bankDetails=" + bankDetails + ", address=" + address
			+ ", landDetails=" + landDetails + ", documentDetails=" + documentDetails + "]";
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
