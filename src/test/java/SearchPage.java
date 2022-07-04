import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchPage {

	public float firstPrice;
	public float secondPrice;
	public float thirdPrice;
	HashMap<String, Float> hotelsWithPrice = new HashMap<>();
	Hotel hotel = new Hotel();
	
	@Parameters({"Location-1" })
	@Test
	public void firstSearch(String Location) throws InterruptedException, IOException {
		
		Actions first=new Actions();
		hotel = first.SearchHotels(Location);
		hotelsWithPrice.put(hotel.name,hotel.price);
	}

	@Parameters({"Location-2" })
	@Test
	public void secondSearch(String Location) throws InterruptedException, IOException {
		Actions second=new Actions();
		hotel = second.SearchHotels( Location);
		hotelsWithPrice.put(hotel.name,hotel.price);
	}

	@Parameters({"Location-3" })
	@Test
	public void thirdSearch(String Location) throws InterruptedException, IOException {
		Actions third=new Actions();
		hotel = third.SearchHotels( Location);
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
