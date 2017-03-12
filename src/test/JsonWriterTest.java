package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import javax.json.JsonObject;

import org.junit.Before;
import org.junit.Test;

import com.expedia.json.JsonReader;
import com.expedia.json.JsonWriter;
import com.expedia.json.Reader;
import com.expedia.json.Writer;
import com.expedia.to.HotelFilterTo;
import com.expedia.to.Offer;

public class JsonWriterTest {
	private Reader<JsonObject> reader = new JsonReader();
	private Writer<Offer> writer = new JsonWriter();
	JsonObject obj;
	
	@Before
	public void init(){
		 try {
			 String testUrl = reader.buildUri(createHotelFilter());
			obj = (JsonObject) reader.getObjectFromStream(reader.read(testUrl));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestwriteToObject() {
		List<Offer> offers =writer.writeToObject(obj);
		assertNotNull(offers);
		for(Offer offer :offers){
			System.out.println(offer.getDestination());
		}
	}
		
	
	private HotelFilterTo createHotelFilter() {
		HotelFilterTo hotelFilter = new HotelFilterTo();
		HashMap map = new HashMap<String,String>();
		map.put("destinationName", "New Orleans");
		hotelFilter.setParameter(map);
		return hotelFilter;
	}

}
