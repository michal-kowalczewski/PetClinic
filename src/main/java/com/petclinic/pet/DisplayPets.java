package com.petclinic.pet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.petclinic.owner.DisplayOwners;
import com.petclinic.type.DisplayTypes;
import com.petclinic.vet.DisplayVets;

@ManagedBean
@SessionScoped
public class DisplayPets {
	private PetDAO petDAO = new PetDAO();
	public DisplayOwners displayOwners = new DisplayOwners();
	private DisplayTypes displayTypes = new DisplayTypes();
	public DisplayVets displayVets = new DisplayVets();
	
	Pet pet = new Pet();
	ArrayList<Pet> pets;
	List<Pet> ownerPets;


	int ownerId;
	HashMap<Integer, String> map = petDAO.getMap();
	
	public DisplayOwners getDisplayOwners() {
		return displayOwners;
	}
	
	public DisplayOwners setDisplayOwners(DisplayOwners displayOwners) {
		return this.displayOwners = displayOwners;
	}
	
	public DisplayTypes getDisplayTypes() {
		return displayTypes;
	}
	
	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
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
	
	
	public List<Pet> getPets() {
		List<Pet> pets = new ArrayList<Pet>();
		pets = petDAO.getAll();
		return pets;
	}
	
	public List<Pet> getOwnerPets() {
		System.out.println("wchodzi do metody");
		List<Pet> ownerPets = new ArrayList<Pet>();
		System.out.println("Display Pets: " + displayOwners.owner.getOwnerId());
		ownerPets = petDAO.getByOwner(displayOwners.owner.getOwnerId());
		return ownerPets;
	}
	
	public void setOwnerPets(ArrayList<Pet> ownerPets) {
		this.ownerPets = ownerPets;
	}
	
	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getPetId() {
		return pet.getPetId();
	}

	public HashMap<Integer, String> getMap() {
		return map;
	}




	

	

	




	
	

}
