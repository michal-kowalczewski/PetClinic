package com.petclinic.vet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

 

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleModel;

import com.petclinic.pet.DisplayPets;
import com.petclinic.visit.DisplayVisits;
import com.petclinic.visit.Visit;
import com.petclinic.visit.VisitDAO;
 
@ManagedBean
@ViewScoped
public class VetSchedule implements Serializable {
      
    private ScheduleModel lazyEventModel;
    DisplayVets displayVets = new DisplayVets();
    DisplayVisits displayVisits = new DisplayVisits();
    DisplayPets displayPets = new DisplayPets();
    VisitDAO visitDAO = new VisitDAO();
    Vet vet = new Vet();
 
 
    @PostConstruct
    public void init() {
         

    }
          
    public ScheduleModel getLazyEventModel() {

        lazyEventModel = new LazyScheduleModel() {        	
            @Override
            public void loadEvents(Date start, Date end) {

                System.out.println("jestem w loadEvents");
                List<Visit> visits = displayVets.getVisitsByVets();
                for(int i=0; i<visits.size(); i++) {             	
                    addEvent(new DefaultScheduleEvent("Pet: "+visits.get(i).getVisitPetName()+ " Vet: "+visits.get(i).getVisitVet(), visits.get(i).getVisitDate(), addMinutes(visits.get(i).getVisitDate())));   
                }           
            }   
        };
        return lazyEventModel;
    }   
    
	public List<Visit> getVisitsByVet() {
		System.out.println("pobiera Visits wg Vetów");
		List<Visit> visitsByVet = new ArrayList<Visit>();
		System.out.println("Display Visits: "+displayVisits.getVetId());
		visitsByVet = visitDAO.getVisitByVet(displayVets.vet.getVetId());
		return visitsByVet;
	}
    
    public Date addMinutes(Date date) {
    	final long ONE_MINUTE_IN_MILLIS=60000;

    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	long t= calendar.getTimeInMillis();
    	return new Date(t + (30 * ONE_MINUTE_IN_MILLIS));
    }
}