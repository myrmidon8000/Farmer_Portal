package com.lti.model;

import java.io.Serializable;


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
public class Login implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_sequence")
	@SequenceGenerator(name="user_sequence",sequenceName="user_sequence")
	@Column
	private int userId;
	@Column
	@NotEmpty(message = "UserName cannot be empty!")
	private String email;
	@Column
	@Size(min = 8, 
	message = " Password must be atleast 8 Characters Long")
	private String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Login(int userId, String email, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login [userId=" + userId + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
