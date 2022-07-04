package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search {
	public WebDriver driver;
	
	By accept_cookies= By.id("accept-all-cookies-button");
	By location = By.cssSelector("[placeholder='Enter place, postcode or hotel']");
	By search = By.id("search-console__form-button");
	
	public Search(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getAcceptCookies()
	{
		return driver.findElement(accept_cookies);
	}
	
	public WebElement getLocation()
	{
		return driver.findElement(location);
	}
	
	public WebElement getSearch()
	{
		return driver.findElement(search);
	}
	


}
