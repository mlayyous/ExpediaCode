package com.expedia.offergenerator;

import java.util.List;

import com.expedia.to.HotelFilterTo;
import com.expedia.to.Offer;

public interface OfferGenerator {
	
	public List<Offer> getOffers(HotelFilterTo hf) throws Exception;		
}
