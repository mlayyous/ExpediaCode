package com.expedia.json;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import com.expedia.to.HotelFilterTo;

public interface Reader<T> {
	
	public InputStream read (String readUrl) throws IOException;
	public String buildUri(HotelFilterTo hotelFilter) throws URISyntaxException;
	public T getObjectFromStream(InputStream in);


}
