package com.expedia.json;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;

import org.apache.http.client.utils.URIBuilder;

import com.expedia.to.HotelFilterTo;

public class JsonReader implements Reader<JsonObject> {

	public InputStream read(String readUrl) throws IOException {
		 URL url = new URL(readUrl);
		 return url.openStream();
	}
	
	@Override
	public JsonObject getObjectFromStream(InputStream in) {
		javax.json.JsonReader rdr =Json.createReader(in);
		  JsonObject obj = rdr.readObject();
		return obj;
	}

	public String buildUri(HotelFilterTo hotelFilter) throws URISyntaxException {
		URIBuilder builder = new URIBuilder();
		buildFixedUriValues(builder);
		hotelFilter.getParameter().forEach((k,v) -> builder.addParameter(k, v));
		String builtUrl= builder.build().toString();
		return builtUrl;
	}

	private void buildFixedUriValues(URIBuilder builder) {
		builder.setScheme("https");
		builder.setHost("offersvc.expedia.com");
		builder.setPath("/offers/v2/getOffers");
		builder.setParameter("scenario", "deal-finder");
		builder.addParameter("page", "foo");
		builder.addParameter("uid", "foo");
		builder.addParameter("productType", "Hotel");
	}



}
