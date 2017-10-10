package com.tutki.PetClinic.Vet;

public class Vet {
	private int vetId;
	private String vetFirstName;
	private String vetLastName;
	
	public Vet() {}

	public Vet(String vetFirstName, String vetLastName) {
		this.vetFirstName = vetFirstName;
		this.vetLastName = vetLastName;
	}

	public Vet(int vetId, String vetFirstName, String vetLastName) {
		this(vetFirstName, vetLastName);
		this.vetId = vetId;
	}

	public int getVetId() {
		return vetId;
	}

	public void setVetId(int vetId) {
		this.vetId = vetId;
	}

	public String getVetFirstName() {
		return vetFirstName;
	}

	public void setVetFirstName(String vetFirstName) {
		this.vetFirstName = vetFirstName;
	}

	public String getVetLastName() {
		return vetLastName;
	}

	public void setVetLastName(String vetLastName) {
		this.vetLastName = vetLastName;
	}	
	
	public String getVetFullName() {
		return vetFirstName + " " + vetLastName;
	}
}
