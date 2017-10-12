package com.tutki.PetClinic.Pet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
	private DisplayOwners displayOwners = new DisplayOwners();
	private DisplayTypes displayTypes = new DisplayTypes();
	
	Pet pet = new Pet();
	ArrayList<Pet> pets;
	List<Pet> ownerPets;


	int ownerId;
	HashMap<Integer, String> map = petDAO.getMap();

	public int getPetId() {
		return pet.getPetId();
	}

	public HashMap<Integer, String> getMap() {
		return map;
	}

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
	
	public List<Pet> getOwnerPets() {
		System.out.println("wchodzi do metody");
		List<Pet> ownerPets = new ArrayList<Pet>();
		ownerPets = petDAO.getByOwner(displayOwners.owner.getOwnerId());
		return ownerPets;
	}
	
	public List<Pet> go(Integer i) {
		List<Pet> ownerPets = new ArrayList<Pet>();
		ownerPets = petDAO.getByOwner(i);
		return ownerPets;
	}


	public void setOwnerPets(ArrayList<Pet> ownerPets) {
		this.ownerPets = ownerPets;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	public void showValue() {
		ownerPets = petDAO.getByOwner(pet.getPetId());
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
