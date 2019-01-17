package com.lti.model;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;
@Component
@Entity
public class PotentialCrop implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column( unique=true)
	private int cropId;
	@Column
	private String cropType;
	@Column
	private String cropName;
	@Column
	private String fertilizerType;
	@Column
	private int quantity;
	@Column
	private long baseAmount;
	@Column
	private String phCertificate;
	@Column
	private String requestStatus;

	@Column
	private int farmerId;
	
	public int getCropId() {
		return cropId;
	}
	public void setCropId(int cropId) {
		this.cropId = cropId;
	}
	public String getCropType() {
		return cropType;
	}
	public void setCropType(String cropType) {
		this.cropType = cropType;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getFertilizerType() {
		return fertilizerType;
	}
	public void setFertilizerType(String fertilizerType) {
		this.fertilizerType = fertilizerType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPhCertificate() {
		return phCertificate;
	}
	public void setPhCertificate(String phCertificate) {
		this.phCertificate = phCertificate;
	}



	
	public PotentialCrop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public long getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(long baseAmount) {
		this.baseAmount = baseAmount;
	}
	@Override
	public String toString() {
		return "PotentialCrop [cropId=" + cropId + ", cropType=" + cropType + ", cropName=" + cropName
				+ ", fertilizerType=" + fertilizerType + ", quantity=" + quantity + ", baseAmount=" + baseAmount
				+ ", phCertificate=" + phCertificate + ", requestStatus=" + requestStatus + ", farmerId=" + farmerId
				+ "]";
	}
	public PotentialCrop(int cropId, String cropType, String cropName, String fertilizerType, int quantity,
			long baseAmount, String phCertificate, String requestStatus, int farmerId) {
		super();
		this.cropId = cropId;
		this.cropType = cropType;
		this.cropName = cropName;
		this.fertilizerType = fertilizerType;
		this.quantity = quantity;
		this.baseAmount = baseAmount;
		this.phCertificate = phCertificate;
		this.requestStatus = requestStatus;
		this.farmerId = farmerId;
	}
	public int getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	
	
	

}
