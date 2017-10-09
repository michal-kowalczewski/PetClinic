package com.tutki.PetClinic.Owner;

public class Owner {
	private Integer ownerId;
	private String ownerFirstName;
	private String ownerLastName;
	private String address;
	private String city;
	private Integer phone;

	public Owner() {
	}

	public Owner(String ownerFirstName, String ownerLastName, String address, String city, Integer phone) {
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.address = address;
		this.city = city;
		this.phone = phone;
	}

	public Owner(int ownerId, String ownerFirstName, String ownerLastName, String address, String city, Integer phone) {
		this(ownerFirstName, ownerLastName, address, city, phone);
		this.ownerId = ownerId;

	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
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

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getOwnerFullName() {
		return ownerFirstName + " " + ownerLastName;
	}
}
