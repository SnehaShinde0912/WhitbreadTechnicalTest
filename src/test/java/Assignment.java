import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map.Entry;

public class Assignment {

	public float firstPrice;
	public float secondPrice;
	public float thirdPrice;
	HashMap<String, Float> hotelsWithPrice = new HashMap<>();
	Hotel hotel = new Hotel();
	
	@Parameters({ "BaseURL", "browser", "count", "Location-1" })
	@Test
	public void firstSearch(String BaseURL, String browser, int count, String Location) throws InterruptedException {
		
		Actions first=new Actions();
		hotel = first.SearchHotels(BaseURL, browser, count, Location);
		hotelsWithPrice.put(hotel.name,hotel.price);
	}

	@Parameters({ "BaseURL", "browser", "count", "Location-2" })
	@Test
	public void secondSearch(String BaseURL, String browser, int count, String Location) throws InterruptedException {
		Actions second=new Actions();
		hotel = second.SearchHotels(BaseURL, browser, count, Location);
		hotelsWithPrice.put(hotel.name,hotel.price);
	}

	@Parameters({ "BaseURL", "browser", "count", "Location-3" })
	@Test
	public void thirdSearch(String BaseURL, String browser, int count, String Location) throws InterruptedException {
		Actions third=new Actions();
		hotel = third.SearchHotels(BaseURL, browser, count, Location);
		hotelsWithPrice.put(hotel.name,hotel.price);
	}
	
	@AfterTest
	public void comparePrices() throws InterruptedException {
		Entry<String, Float> min = null;
		for (Entry<String, Float> entry : hotelsWithPrice.entrySet()) {
		    if (min == null || min.getValue() > entry.getValue()) {
		        min = entry;
		    }
		}
		System.out.println("Lowest Price Hotel name is : " + min.getKey());
		System.out.println("Lowest Price is : " + min.getValue());
	}
}
