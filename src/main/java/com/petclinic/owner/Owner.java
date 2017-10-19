package com.petclinic.owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class Owner {
	private Integer ownerId;
	private String ownerFirstName;
	private String ownerLastName;
	private String address;
	private String city;
	private Integer phone;
	
	public Owner(String ownerFirstName, String ownerLastName, String address, String city, Integer phone) {
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.address = address;
		this.city = city;
		this.phone = phone;
	}
	
	public String getOwnerFullName() {
		return ownerFirstName + " " + ownerLastName;
	}
}
