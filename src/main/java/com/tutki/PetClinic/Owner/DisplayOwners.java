package com.tutki.PetClinic.Owner;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
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
	
	public void addOwner() {
		ownerDAO.insertOwner(owner);
		owner = new Owner();
		FacesContext context = FacesContext.getCurrentInstance();
		String viewId = context.getViewRoot().getViewId();
		ViewHandler handler = context.getApplication().getViewHandler();
		UIViewRoot root = handler.createView(context, viewId);
		root.setViewId(viewId);
		context.setViewRoot(root);
	}
}
