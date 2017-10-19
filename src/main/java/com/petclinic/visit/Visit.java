package com.petclinic.visit;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public @Data class Visit {
	private int visitId;
	private String visitPetName;
	private String visitPetType;
	private String visitPetOwner;
	private String visitVet;
	private Date visitDate;
	private Integer visitPetId;
	private Integer visitVetId;
	
	public Visit(String visitPetName, String visitPetType, String visitPetOwner, String visitVet, Date visitDate) {
		this.visitPetName = visitPetName;
		this.visitPetType = visitPetType;
		this.visitPetOwner = visitPetOwner;
		this.visitVet = visitVet;
		this.visitDate = visitDate;
	}
	
	public Visit(int visitId, String visitPetName, String visitPetType, String visitPetOwner, String visitVet, Date visitDate) {
		this.visitId = visitId;	
		this.visitPetName = visitPetName;
		this.visitPetType = visitPetType;
		this.visitPetOwner = visitPetOwner;
		this.visitVet = visitVet;
		this.visitDate = visitDate;
	}
}
