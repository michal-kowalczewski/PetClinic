package com.tutki.PetClinic.Visit;

import java.util.Date;

public class Visit {
	private int visitId;
	private String visitPetName;
	private String visitPetType;
	private String visitPetOwner;
	private String visitVet;
	private Date visitDate;
	private Integer visitPetId;
	private Integer visitVetId;
	
	public Visit() {}
	
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

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	
	public Integer getVisitPetId() {
		return visitPetId;
	}

	public void setVisitPetId(Integer visitPetId) {
		this.visitPetId = visitPetId;
	}

	public Integer getVisitVetId() {
		return visitVetId;
	}

	public void setVisitVetId(Integer visitVetId) {
		this.visitVetId = visitVetId;
	}
	/*
	private Date refactorDate(Date date) {
		try {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String string = format.format(date);
		Date newDate = format.parse(string);
		return newDate;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}	*/
}
