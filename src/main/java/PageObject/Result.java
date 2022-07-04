package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Result {
	public WebDriver driver;
	
	By hotelName = By.xpath("(//hotel-name//name)[1]");
	By viewDetails = By.xpath("//*[@id=\"hotel-card-0\"]/cta-wrapper/hotel-rate/cta-button");

	public Result(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getHotelName()
	{
		return driver.findElement(hotelName);
	}
	
	public WebElement getViewDetails()
	{
		return driver.findElement(viewDetails);
	}
}
