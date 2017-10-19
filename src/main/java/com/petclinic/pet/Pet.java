package com.petclinic.pet;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Pet {
	private int petId;
	private String petName;
	private int petTypeId;
	private int petOwnerId;
	private String petType;
	private String petOwner;
		
	public Pet(String petName, String petType, String petOwner) {
		this.petName = petName;
		this.petType = petType;
		this.petOwner = petOwner;
	}
	
	public Pet(int petId, String petName, int petTypeId, int petOwnerId) {
		this.petId = petId;
		this.petName = petName;
		this.petTypeId = petTypeId;
		this.petOwnerId = petOwnerId;
	}
	
	public Pet(int petId, String petName, String petType, String petOwner) {
		this(petName, petType, petOwner);
		this.petId = petId;
	}
}
