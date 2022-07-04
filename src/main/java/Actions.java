import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObject.Details;
import PageObject.Result;
import PageObject.Search;
import java.io.IOException;
import java.time.Duration;

public class Actions extends Base{

    public WebDriver driver;
    public String hotelName;    
    public Hotel hotel=new Hotel();
    
    
    public Hotel SearchHotels(String Location) throws InterruptedException, IOException {
    	driver = initializeDriver();
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(500));
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));    
        Search search=new Search(driver);
    	Result result=new Result(driver);
    	Details details=new Details(driver);
        wait.until(ExpectedConditions.visibilityOf(search.getAcceptCookies()));
        // Accept Cookies
        search.getAcceptCookies().click();   
        // Search Location
        search.getLocation().sendKeys(Location);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        search.getSearch().click();
        // Wait for Hotels to appears
        wait.until(ExpectedConditions.visibilityOf(result.getHotelName()));
        hotelName = result.getHotelName().getText();
        wait.until(ExpectedConditions.visibilityOf(result.getViewDetails()));
        result.getViewDetails().click();
        //Check the standard room and its flex rate
        String roomType = details.getRoomType().getText();
        if(roomType.equals("Standard Room"))
        {
	        String flexRate;
	        flexRate = details.getFlexRate().getText();
	        //Replacing all characters except numbers
	        flexRate = flexRate.replaceAll("[^0-9.]","");//Replace anything wil space other than numbers
	        hotel.name=hotelName;
	        hotel.price=Float.parseFloat(flexRate);
	        System.out.println("Location : " + Location);
	        System.out.println("Hotel name : " + hotel.name);
	        System.out.println("Standard room price : " + hotel.price);
        }
        else
        {
        	System.out.println("Location : " + Location);
        	hotel.name="No Standard Room Available";
	        hotel.price=Float.MAX_VALUE;
	        System.out.println("Hotel name : " + hotel.name);
        }
        driver.quit();
        return hotel;
    }
}
