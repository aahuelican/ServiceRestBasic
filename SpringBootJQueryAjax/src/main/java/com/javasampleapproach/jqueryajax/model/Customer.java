package com.javasampleapproach.jqueryajax.model;

public class Customer {
    private String    		   firstname;
    private String    		   lastname;
    private String             trabajo;
    
	public Customer(){}
      
    public Customer(String firstname, String lastname,String trabajo){
        this.firstname = firstname;
        this.lastname = lastname;
        this.trabajo  = trabajo;   
    }
    
    public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
    
    // firstname
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
      
    // lastname
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}