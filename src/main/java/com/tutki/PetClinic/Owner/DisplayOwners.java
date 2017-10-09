package com.tutki.PetClinic.Owner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;




@ManagedBean
@SessionScoped
public class DisplayOwners {
	private OwnerDAO ownerDAO = new OwnerDAO();
	Owner owner = new Owner();
	ArrayList<Owner> owners;

	public List<Owner> getOwners() {
		List<Owner> owners = new ArrayList<Owner>();
		owners = ownerDAO.getAll();
		return owners;
	}
		
	public void setOwner(String ownerFirstName, String ownerLastName, String address, String city, int phone) {
		owner.setOwnerFirstName(ownerFirstName);
		owner.setOwnerLastName(ownerLastName);
		owner.setAddress(address);
		owner.setCity(city);
		owner.setPhone(phone);
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public String addOwner() {
		ownerDAO.insertOwner(owner);
		owner = new Owner();
		ExternalContext ec = FacesContext.getCurrentInstance()
		        .getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath()
			        + "/Owner/new_owner.jsf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int getOwnerId() {
		return owner.getOwnerId();
	}
}
