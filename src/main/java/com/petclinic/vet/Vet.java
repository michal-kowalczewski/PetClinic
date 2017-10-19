package com.petclinic.vet;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Vet {
	private int vetId;
	private String vetFirstName;
	private String vetLastName;
	@Getter private static int tempVetId; 
	
	public Vet(String vetFirstName, String vetLastName) {
		this.vetFirstName = vetFirstName;
		this.vetLastName = vetLastName;
	}

	public Vet(int vetId, String vetFirstName, String vetLastName) {
		this(vetFirstName, vetLastName);
		this.vetId = vetId;
	}
	
	public void setVetId(int vetId) {
		tempVetId = vetId;
		this.vetId = vetId;
	}
	
	public String getVetFullName() {
		return vetFirstName + " " + vetLastName;
	}	
}
