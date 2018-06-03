package org.igt.PlayerServicesManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class PSMUser {
	
	@Id
	@GeneratedValue
	private int psmId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	public int getPsmId() {
		return psmId;
	}
	public void setPsmId(int psmId) {
		this.psmId = psmId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
