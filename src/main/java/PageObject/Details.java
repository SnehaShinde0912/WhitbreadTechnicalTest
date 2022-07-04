package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Details {
	public WebDriver driver;
	
	By roomType = By.cssSelector("[class='room-title-row__title mb3']");
	By flexRate= By.cssSelector("[class='rate-tile rate-tile--selected'] span[class='m0']");
	
	
	public Details(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getRoomType()
	{
		return driver.findElement(roomType);
	}
	
	public WebElement getFlexRate()
	{
		return driver.findElement(flexRate);
	}
	
//	public void comparePrice()
//	{
//		   if(roomType.equals("Standard Room"))
//	        {
//		        String flexRate;
//		        flexRate = driver.findElement(By.cssSelector("[class='rate-tile rate-tile--selected'] span[class='m0']")).getText();
//		        //Replacing all characters except numbers
//		        flexRate = flexRate.replaceAll("[^0-9.]","");//Replace anything wil space other than numbers
//		        hotel.name=hotelName;
//		        hotel.price=Float.parseFloat(flexRate);
//		        System.out.println("Location : " + Location);
//		        System.out.println("Hotel name : " + hotel.name);
//		        System.out.println("Standard room price : " + hotel.price);
//	        }
//	        else
//	        {
//	        	System.out.println("Location : " + Location);
//	        	hotel.name="No Standard Room Available";
//		        hotel.price=Float.MAX_VALUE;
//		        System.out.println("Hotel name : " + hotel.name);
//	        }
//	}
}
