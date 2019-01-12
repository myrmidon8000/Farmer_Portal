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

import org.springframework.stereotype.Component;
@Component
@Entity
public class LandDetails implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="land_sequence")
	@SequenceGenerator(name="land_sequence",sequenceName="land_sequence")
	@Column
	private int landId;
	@Column 
	private String landAddress;
	@Column
	private String landCity;
	
	@OneToOne(cascade=CascadeType.ALL)
	private State state;
	
	public int getLandId() {
		return landId;
	}
	public void setLandId(int landId) {
		this.landId = landId;
	}
	public String getLandAddress() {
		return landAddress;
	}
	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}
	public String getLandCity() {
		return landCity;
	}
	public void setLandCity(String landCity) {
		this.landCity = landCity;
	}
	public State getState() {
		return state;
	}
	@Override
	public String toString() {
		return "LandDetails [landId=" + landId + ", landAddress=" + landAddress + ", landCity=" + landCity + ", state="
				+ state + "]";
	}
	public LandDetails(String landAddress, String landCity,State state) {
		super();
		this.landAddress = landAddress;
		this.landCity = landCity;
		this.state=state;
	}
	public LandDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
