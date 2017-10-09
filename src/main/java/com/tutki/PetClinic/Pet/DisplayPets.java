package com.tutki.PetClinic.Pet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.tutki.PetClinic.Owner.DisplayOwners;
import com.tutki.PetClinic.Type.DisplayTypes;

@ManagedBean
@SessionScoped
public class DisplayPets {
	private PetDAO petDAO = new PetDAO();
	DisplayOwners displayOwners = new DisplayOwners();
	DisplayTypes displayTypes = new DisplayTypes();
	Pet pet = new Pet();
	ArrayList<Pet> pets;
	int ownerId;

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public List<Pet> getPets() {
		List<Pet> pets = new ArrayList<Pet>();
		pets = petDAO.getAll();
		return pets;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	public String showValue() {
		System.out.println("blabla");
		return "test";
	}
	
	public String addPet() {
		pet.setPetOwnerId(displayOwners.getOwnerId());
		pet.setPetTypeId(displayTypes.getTypeId());
		petDAO.insertPet(pet);
		pet = new Pet();
		ExternalContext ec = FacesContext.getCurrentInstance()
		        .getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath()
			        + "/Pet/new_pet.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public DisplayOwners getDisplayOwners() {
		return displayOwners;
	}

	public DisplayTypes getDisplayTypes() {
		return displayTypes;
	}

	
	

}
