package com.tutki.PetClinic.Owner;

public class Owner {
	private int ownerId;
	private String ownerFirstName;
	private String ownerLastName;
	private String address;
	private String city;
	private int phone;
	
	public Owner() {}	
	
	public Owner(String ownerFirstName, String ownerLastName, String address, String city, int phone) {
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.address = address;
		this.city = city;
		this.phone = phone;
	}
	
	

	public Owner(int ownerId, String ownerFirstName, String ownerLastName, String address, String city, int phone) {
		this(ownerFirstName, ownerLastName, address, city, phone);
		this.ownerId = ownerId;

	}

	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}
	public String getOwnerLastName() {
		return ownerLastName;
	}
	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
}
