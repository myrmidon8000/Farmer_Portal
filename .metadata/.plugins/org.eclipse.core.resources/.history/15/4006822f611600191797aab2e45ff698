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
import javax.validation.constraints.NotEmpty;

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
	
	@OneToOne(cascade=CascadeType.ALL)
	private BidderDetails bidderDetails;
	
	@OneToOne(cascade=CascadeType.ALL)
	private User user;

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

	public BidderDetails getBidderDetails() {
		return bidderDetails;
	}

	public void setBidderDetails(BidderDetails bidderDetails) {
		this.bidderDetails = bidderDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Bidder [bidderId=" + bidderId + ", bidderName=" + bidderName + ", bidderDetails=" + bidderDetails
				+ ", user=" + user + "]";
	}

	public Bidder(String bidderName) {
		super();
		this.bidderName = bidderName;
		this.bidderDetails=bidderDetails;
		this.user=user;
	}

	public Bidder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
