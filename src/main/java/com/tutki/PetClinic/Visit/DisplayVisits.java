package com.tutki.PetClinic.Visit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.tutki.PetClinic.Pet.DisplayPets;
import com.tutki.PetClinic.Vet.DisplayVets;


@ManagedBean
@SessionScoped
public class DisplayVisits {
	private VisitDAO visitDAO = new VisitDAO();
	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	DisplayPets displayPets= new DisplayPets();
	DisplayVets displayVets = new DisplayVets();

	Visit visit = new Visit();
	ArrayList<Visit> visits;
	int petId, vetId;

	public List<Visit> getVisits() {
		List<Visit> visits = new ArrayList<Visit>();
		visits = visitDAO.getAll();
		return visits;
	}
	
	public String addVisit() {
		visit.setVisitPetId(displayPets.getPetId());
		visit.setVisitVetId(displayVets.getVetId());

		visitDAO.insertVisit(visit);
		visit = new Visit();
		ExternalContext ec = FacesContext.getCurrentInstance()
		        .getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath()
			        + "/Visit/new_visit.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getVetId() {
		return vetId;
	}

	public void setVetId(int vetId) {
		this.vetId = vetId;
	}

	public DisplayPets getDisplayPets() {
		return displayPets;
	}

	public DisplayVets getDisplayVets() {
		return displayVets;
	}

	
	

}
