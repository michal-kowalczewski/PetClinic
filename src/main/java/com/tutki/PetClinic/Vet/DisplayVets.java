package com.tutki.PetClinic.Vet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DisplayVets {
	private VetDAO vetDAO = new VetDAO();
	Vet vet = new Vet();
	ArrayList<Vet> pets;

	public List<Vet> getVets() {
		List<Vet> vets = new ArrayList<Vet>();
		vets = vetDAO.getAll();
		return vets;
	}
	
	public void setVet(String vetFirstName, String vetLastName) {
		vet.setVetFirstName(vetFirstName);
		vet.setVetLastName(vetLastName);
	}

	public Vet getVet() {
		return vet;
	}
	
	public void addVet() {
		vetDAO.insertVet(vet);
		vet = new Vet();

	}

	
	

}
