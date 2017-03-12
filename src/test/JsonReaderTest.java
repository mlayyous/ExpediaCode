package test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;

import org.apache.http.client.utils.URIBuilder;
import org.junit.Assert;
import org.junit.Test;

import com.expedia.json.JsonReader;
import com.expedia.json.Reader;
import com.expedia.to.HotelFilterTo;



public class JsonReaderTest {
private Reader read = new JsonReader();

	@Test
	public void testConnetion(){
		try {
			HotelFilterTo hotelFilter = createHotelFilter();
			String testUrl = read.buildUri(hotelFilter);
			System.out.println(testUrl);
			 JsonObject obj = (JsonObject) read.getObjectFromStream(read.read(testUrl));
			  Assert.assertNotNull("no Connection", obj);
			  JsonArray results = obj.getJsonObject("offers").getJsonArray("Hotel");
			  for (JsonObject result : results.getValuesAs(JsonObject.class)) {
			  printTestResults(result);
			  }
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 
			 
		
}
	
@Test
public void testUriBuilder(){
	HotelFilterTo hotelFilter = createHotelFilter();
	try {
		 Assert.assertNotNull("No Uri", read.buildUri(hotelFilter));;
	} catch (URISyntaxException e) {
		e.printStackTrace();
	}
}
	
	private HotelFilterTo createHotelFilter() {
		HotelFilterTo hotelFilter = new HotelFilterTo();
		HashMap map = new HashMap<String,String>();
		map.put("destinationName", "New Orleans");
		hotelFilter.setParameter(map);
		return hotelFilter;
	}
	private void printTestResults(JsonObject result) {
		System.out.println(result.getJsonObject("destination").getString("longName"));
	}
	
	
}