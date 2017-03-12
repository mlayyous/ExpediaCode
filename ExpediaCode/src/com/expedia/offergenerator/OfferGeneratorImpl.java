package com.expedia.offergenerator;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonObject;

import com.expedia.json.JsonReader;
import com.expedia.json.JsonWriter;
import com.expedia.json.Reader;
import com.expedia.json.Writer;
import com.expedia.to.HotelFilterTo;
import com.expedia.to.Offer;

public class OfferGeneratorImpl implements OfferGenerator{
	
	private Reader<JsonObject> reader;
	private Writer<Offer> writer;
	
	public OfferGeneratorImpl(){
		reader= new JsonReader();
		writer = new JsonWriter();
	}
	
	
	
	@Override
	public List<Offer> getOffers(HotelFilterTo hf) throws Exception {
		String testUrl = reader.buildUri(hf);
		System.out.println(testUrl);
		 JsonObject obj = (JsonObject) reader.getObjectFromStream(reader.read(testUrl));
		 return writer.writeToObject(obj);
}

	
	
	
}
