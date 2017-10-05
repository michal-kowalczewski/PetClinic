package com.tutki.PetClinic.Owner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class DisplayOwners {
	final OwnerDAO ownerDAO = new OwnerDAO();
	Owner owner = new Owner();
	ArrayList<Owner> owners;

	public List<Owner> getOwners() {
		List<Owner> owners = new ArrayList<Owner>();
		owners = ownerDAO.getAll();
		return owners;
	}

	
	

}
