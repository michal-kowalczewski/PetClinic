package com.tutki.PetClinic.Pet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class DisplayPets {
	private PetDAO petDAO = new PetDAO();
	Pet pet = new Pet();
	ArrayList<Pet> pets;

	public List<Pet> getPets() {
		List<Pet> pets = new ArrayList<Pet>();
		pets = petDAO.getAll();
		return pets;
	}

	
	

}
