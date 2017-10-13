package com.tutki.PetClinic.Vet;

public class Vet {
	private int vetId;
	private String vetFirstName;
	private String vetLastName;
	private static int tempVetId; 
	
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
		System.out.println("GETTER");
		System.out.println(" vetId: " + vetId);
		System.out.println(" vetId: " + this.vetId);
		System.out.println(" tempVetId: " + tempVetId);
		return vetId;
	}

	public void setVetId(int vetId) {
		tempVetId = vetId;
		this.vetId = vetId;
		System.out.println("SETTER");
		System.out.println(" vetId: " + vetId);
		System.out.println(" vetId: " + this.vetId);
		System.out.println(" tempVetId: " + tempVetId);
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

	public static int getTempVetId() {
		return tempVetId;
	}
	
	
}
