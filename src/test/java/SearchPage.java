import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import PageObject.Details;
import PageObject.Result;
import PageObject.Search;

public class SearchPage extends base {
//	@BeforeTest
//	public void navugation() throws IOException
//	{
//		driver = initializeDriver();
//		//driver.get(prop.getProperty("url"));
//	}
//		
//	@Test(dataProvider="getData")
//	public void hotelSearch(String location) throws IOException {
//		driver = initializeDriver();
//		driver.get(prop.getProperty("url"));
//		
//		Search search=new Search(driver);
//		Result result=new Result(driver);
//		Details details=new Details(driver);
//		
//		search.getAcceptCookies().click();
//		search.getLocation().sendKeys(location);
//		search.getSearch().click();			
//		result.getViewDetails().click();		
//		Assert.assertEquals(details.getRoomType().getText(),"Standard Room");
//		
//		
//		
//		
//	}
//	@AfterTest()
//	public void closeBrowser()
//	{
//		driver.quit();
//	}
//	
//	@DataProvider
//	public Object[][] getData()
//	{
//		Object[][] data= new Object[2][1];
//		data[0][0]="Leeds";
//		data[1][0]="Manchester";
//		
//		return data;
//	
//	}
	
	public float firstPrice;
	public float secondPrice;
	public float thirdPrice;
	HashMap<String, Float> hotelsWithPrice = new HashMap<>();
	Hotel hotel = new Hotel();
	
	@Parameters({"Location-1" })
	@Test
	public void firstSearch( String Location) throws InterruptedException, IOException {
		
		Actions first=new Actions();
		hotel = first.SearchHotels(Location);
		hotelsWithPrice.put(hotel.name,hotel.price);
	}

	@Parameters({"Location-2" })
	@Test
	public void secondSearch( String Location) throws InterruptedException, IOException {
		Actions second=new Actions();
		hotel = second.SearchHotels( Location);
		hotelsWithPrice.put(hotel.name,hotel.price);
	}

	@Parameters({"Location-3" })
	@Test
	public void thirdSearch( String Location) throws InterruptedException, IOException {
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
