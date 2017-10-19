package com.petclinic.visit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.petclinic.pet.DisplayPets;
import com.petclinic.vet.DisplayVets;


@ManagedBean
@SessionScoped
public class DisplayVisits {
	private VisitDAO visitDAO = new VisitDAO();
	private DisplayPets displayPets= new DisplayPets();
	public DisplayVets displayVets = new DisplayVets();
	
	Visit visit = new Visit();
	ArrayList<Visit> visits;
	ArrayList<Visit> visitsByVet;
	
	int petId, vetId;
	
	public DisplayPets getDisplayPets() {
		return displayPets;
	}

	public DisplayVets getDisplayVets() {
		return displayVets;
	}
	
	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
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
	
	public List<Visit> getVisits() {
		List<Visit> visits = new ArrayList<Visit>();
		System.out.println("Display Visits : "+displayVets.vet.getVetId());
		visits = visitDAO.getAll();
		return visits;
	}
	
	
	public List<Visit> getVisitsByVet() {
		System.out.println("pobiera Visits wg Vetów");
		List<Visit> visitsByVet = new ArrayList<Visit>();
		System.out.println("Display Visits : "+displayVets.vet.getVetId());
		visitsByVet = visitDAO.getVisitByVet(displayVets.vet.getVetId());
		return visitsByVet;
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


	





	
	

}
