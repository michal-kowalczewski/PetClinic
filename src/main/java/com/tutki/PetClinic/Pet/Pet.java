package com.tutki.PetClinic.Pet;

public class Pet {
	private int petId;
	private String petName;
	private int petTypeId;
	private int petOwnerId;
	private String petType;
	private String petOwner;
	
	public Pet() {}
	
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

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public String getPetOwner() {
		return petOwner;
	}

	public void setPetOwner(String petOwner) {
		this.petOwner = petOwner;
	}	
	
	public int getPetTypeId() {
		return petTypeId;
	}

	public void setPetTypeId(int petTypeId) {
		this.petTypeId = petTypeId;
	}

	public int getPetOwnerId() {
		return petOwnerId;
	}

	public void setPetOwnerId(int petOwnerId) {
		this.petOwnerId = petOwnerId;
	}
}
