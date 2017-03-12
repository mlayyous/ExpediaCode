package com.expedia.json;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonObject;

import com.expedia.to.Offer;

public class JsonWriter implements Writer<Offer> {
	
	@Override
	public List<Offer> writeToObject(JsonObject obj) {
		List<Offer> offers = new ArrayList<Offer>();
		Offer offer = new Offer();
		  populateOffers(offers, offer, obj);
		  return offers;
		  }

	private void populateOffers(List<Offer> offers, Offer offer, JsonObject obj) {
		JsonArray results = obj.getJsonObject("offers").getJsonArray("Hotel");
		if (results != null) {
			for (JsonObject result : results.getValuesAs(JsonObject.class)) {
				offer.setLengthOfStay(result.getJsonObject("offerDateRange").getInt("lengthOfStay"));
				offer.setDestination(result.getJsonObject("destination").getString("longName"));
				offer.setMinTripStartDate(result.getJsonObject("offerDateRange").getJsonArray("travelStartDate"));
				offer.setMaxTripStartDate(result.getJsonObject("offerDateRange").getJsonArray("travelEndDate"));
				offers.add(offer);
			}
		}
	}


}
