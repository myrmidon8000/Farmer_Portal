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

@OneToOne(cascade=CascadeType.ALL)
private User user;

@OneToOne(cascade=CascadeType.ALL)
private FarmerDetails farmerDetails;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public FarmerDetails getFarmerDetails() {
	return farmerDetails;
}
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
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Farmer [farmerId=" + farmerId + ", farmerName=" + farmerName + ", user=" + user + ", farmerDetails="
			+ farmerDetails + "]";
}
public Farmer(String farmerName,User user,FarmerDetails farmerDetails) {
	super();

	this.farmerName = farmerName;
	this.user=user;
	this.farmerDetails=farmerDetails;
}


}
