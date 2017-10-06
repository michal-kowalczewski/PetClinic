package com.tutki.PetClinic.Visit;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class DisplayVisits {
	private VisitDAO visitDAO = new VisitDAO();
	Visit visit = new Visit();
	ArrayList<Visit> visits;

	public List<Visit> getVisits() {
		List<Visit> visits = new ArrayList<Visit>();
		visits = visitDAO.getAll();
		return visits;
	}

	
	

}
