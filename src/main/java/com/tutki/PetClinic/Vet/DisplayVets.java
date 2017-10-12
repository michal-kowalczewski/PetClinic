package com.tutki.PetClinic.Vet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class DisplayVets {
	private VetDAO vetDAO = new VetDAO();
	public Vet vet = new Vet();
	ArrayList<Vet> vets;
	
	int vetId;
	
	public Vet getVet() {
		return vet;
	}
	
	public void setVet(Vet vet) {
		this.vet = vet;
	}
	
	public void setVet(String vetFirstName, String vetLastName) {
		vet.setVetFirstName(vetFirstName);
		vet.setVetLastName(vetLastName);
	}
	
	public String addVet() {
		vetDAO.insertVet(vet);
		vet = new Vet();
		ExternalContext ec = FacesContext.getCurrentInstance()
		        .getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath()
			        + "/Vet/new_vet.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Vet> getVets() {
		List<Vet> vets = new ArrayList<Vet>();
		vets = vetDAO.getAll();
		return vets;
	}

	public int getVetId() {
		return vet.getVetId();
	}
	
	public void setVetId(int i) {
		this.vet.setVetId(i);
	}

	



	

	



	
	

}
