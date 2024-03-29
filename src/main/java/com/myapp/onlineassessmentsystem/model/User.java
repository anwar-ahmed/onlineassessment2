package com.myapp.onlineassessmentsystem.model;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {
	
	@Id
	private String email;
	private String password;
    private String firstname;
    private String lastname;
    private String usertype;
    
    
    public User() {}

    public User(String email, String password,String firstname, String lastname, String usertype) {
        this.email = email;
        this.password = password;
        this.firstname=  firstname;
        this.lastname = lastname;
        this.usertype = usertype;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
    
}
