package com.expedia.to;

import java.io.Serializable;

import javax.json.JsonArray;

public class Offer implements Serializable {

	private static final long serialVersionUID = -6804643159044695288L;
	
	private String destination;
	private int lengthOfStay;
	private JsonArray minTripStartDate;
	private JsonArray maxTripStartDate;

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay(int lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}

	public JsonArray getMinTripStartDate() {
		return minTripStartDate;
	}

	public void setMinTripStartDate(JsonArray minTripStartDate) {
		this.minTripStartDate = minTripStartDate;
	}

	public JsonArray getMaxTripStartDate() {
		return maxTripStartDate;
	}

	public void setMaxTripStartDate(JsonArray maxTripStartDate) {
		this.maxTripStartDate = maxTripStartDate;
	}

	
}
