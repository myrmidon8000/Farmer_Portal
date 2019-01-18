package com.lti.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component
@Entity
public class AcceptedBid implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column( unique=true)
	private int acceptedBidId;
	@Column
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
	private int farmerId;
	@Column
	private String bidAmount;
	@Column
	private String bidderid;
	@Column
	private String bidStatus;
	
	
	
	public AcceptedBid(int cropId, String cropType, String cropName, String fertilizerType, int quantity,
			long baseAmount, String phCertificate, int farmerId, String bidAmount, String bidderid, String bidStatus) {
		super();
		this.cropId = cropId;
		this.cropType = cropType;
		this.cropName = cropName;
		this.fertilizerType = fertilizerType;
		this.quantity = quantity;
		this.baseAmount = baseAmount;
		this.phCertificate = phCertificate;
		this.farmerId = farmerId;
		this.bidAmount = bidAmount;
		this.bidderid = bidderid;
		this.bidStatus = bidStatus;
	}
	public String getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}
	public int getAcceptedBidId() {
		return acceptedBidId;
	}
	public void setAcceptedBidId(int acceptedBidId) {
		this.acceptedBidId = acceptedBidId;
	}
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
	public long getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(long baseAmount) {
		this.baseAmount = baseAmount;
	}
	public String getPhCertificate() {
		return phCertificate;
	}
	public void setPhCertificate(String phCertificate) {
		this.phCertificate = phCertificate;
	}
	public int getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	public String getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(String bidAmount) {
		this.bidAmount = bidAmount;
	}
	public String getBidderid() {
		return bidderid;
	}
	public void setBidderid(String bidderid) {
		this.bidderid = bidderid;
	}
	@Override
	public String toString() {
		return "AcceptedBid [acceptedBidId=" + acceptedBidId + ", cropId=" + cropId + ", cropType=" + cropType
				+ ", cropName=" + cropName + ", fertilizerType=" + fertilizerType + ", quantity=" + quantity
				+ ", baseAmount=" + baseAmount + ", phCertificate=" + phCertificate + ", farmerId=" + farmerId
				+ ", bidAmount=" + bidAmount + ", bidderid=" + bidderid + ", bidStatus=" + bidStatus + "]";
	}
	public AcceptedBid() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}