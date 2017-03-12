package com.expedia.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.expedia.offergenerator.OfferGenerator;
import com.expedia.offergenerator.OfferGeneratorImpl;
import com.expedia.to.HotelFilterTo;
import com.expedia.to.Offer;

public class FilterBean {
	
    private List<Offer> offers;
	
	private String destinationName;
	private String lengthstay;
	private Date minTripStartDate;
	private Date maxTripStartDate;

	private OfferGenerator offerGen;
	private HotelFilterTo hf;
	
	public FilterBean(){
		offerGen= new OfferGeneratorImpl();
	}

	  public void buttonAction(ActionEvent actionEvent) {
	        FacesContext context = FacesContext.getCurrentInstance();
		  generateHotelFilter();
		  try {
			offers= offerGen.getOffers(hf);
		} catch (Exception e) {
	        context.addMessage(null, new FacesMessage("error") );
			e.printStackTrace();
		}
		  
	    }

	private void generateHotelFilter() {
		hf = new HotelFilterTo();
		  HashMap<String, String> map = new HashMap<String, String>();
		 if  (getDestinationName()!=null && !getDestinationName().isEmpty())
		  map.put("destinationName", getDestinationName());
		 if  (getLengthstay()!=null && !getLengthstay().isEmpty())
			  map.put("lengthOfStay", getLengthstay());
		 if  (getMinTripStartDate()!=null){
			 SimpleDateFormat dt1 = new SimpleDateFormat(":yyyy-MM-dd");
			  map.put("minTripStartDate", dt1.format(getMinTripStartDate()));
		 }if  (getMaxTripStartDate()!=null){
			 SimpleDateFormat dt1 = new SimpleDateFormat(":yyyy-MM-dd");
			  map.put("maxTripStartDate", dt1.format(getMaxTripStartDate()));
		 }
		 hf.setParameter(map);
		
	}
	
	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public String getLengthstay() {
		return lengthstay;
	}

	public void setLengthstay(String lengthstay) {
		this.lengthstay = lengthstay;
	}

	public Date getMinTripStartDate() {
		return minTripStartDate;
	}

	public void setMinTripStartDate(Date minTripStartDate) {
		this.minTripStartDate = minTripStartDate;
	}

	public Date getMaxTripStartDate() {
		return maxTripStartDate;
	}

	public void setMaxTripStartDate(Date maxTripStartDate) {
		this.maxTripStartDate = maxTripStartDate;
	}
	
}
