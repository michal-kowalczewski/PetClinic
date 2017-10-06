package com.tutki.PetClinic.Visit;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Visit {
	private int visitId;
	private String visitPetName;
	private String visitPetType;
	private String visitPetOwner;
	private String visitVet;
	private String visitDate;
	
	public Visit() {}
	
	public Visit(String visitPetName, String visitPetType, String visitPetOwner, String visitVet, String visitDate) {
		this.visitPetName = visitPetName;
		this.visitPetType = visitPetType;
		this.visitPetOwner = visitPetOwner;
		this.visitVet = visitVet;
		this.visitDate = visitDate;
	}
	
	public Visit(int visitId, String visitPetName, String visitPetType, String visitPetOwner, String visitVet, String visitDate) {
		this.visitId = visitId;	
		this.visitPetName = visitPetName;
		this.visitPetType = visitPetType;
		this.visitPetOwner = visitPetOwner;
		this.visitVet = visitVet;
		this.visitDate = refactorDate(visitDate);
	}
	
	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public String getVisitPetName() {
		return visitPetName;
	}

	public void setVisitPetName(String visitPetName) {
		this.visitPetName = visitPetName;
	}

	public String getVisitPetType() {
		return visitPetType;
	}

	public void setVisitPetType(String visitPetType) {
		this.visitPetType = visitPetType;
	}

	public String getVisitPetOwner() {
		return visitPetOwner;
	}

	public void setVisitPetOwner(String visitPetOwner) {
		this.visitPetOwner = visitPetOwner;
	}

	public String getVisitVet() {
		return visitVet;
	}

	public void setVisitVet(String visitVet) {
		this.visitVet = visitVet;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	
	private String refactorDate(String dateString) {
		try {
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
		return dateString = new SimpleDateFormat("dd/MM/yy HH:mm").format(date);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
