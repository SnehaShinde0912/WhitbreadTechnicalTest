import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Actions {

    public WebDriver driver;
    public String hotelName;
    public Hotel hotel=new Hotel();
    public Hotel SearchHotels(String BaseURL, String browser, String Location) throws InterruptedException {
        //declare either webdriver chrome or firefox
        if(browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver","webdrivers/chromedriver.exe");
            driver = new ChromeDriver(); //initialize webdriver
        }else if (browser.equals("FireFox")){
            System.setProperty("webdriver.gecko.driver","webdrivers/geckodriver.exe");
            driver = new FirefoxDriver(); //initialize webdriver
        }
        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(500));
        driver.manage().window().maximize(); // maximizing Window
        // opening BaseURL, BaseURL is passed as parameter from xml file
        driver.get(BaseURL);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        //Accepting cooking
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("accept-all-cookies-button")));
        driver.findElement(By.id("accept-all-cookies-button")).click();
        //Passing Location and Click on Search
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[placeholder='Enter place, postcode or hotel']")));
        driver.findElement(By.cssSelector("[placeholder='Enter place, postcode or hotel']")).sendKeys(Location);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(By.id("search-console__form-button")).click();
        // Wait for Hotels to appears
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//hotel-name//name)[1]")));
        hotelName = driver.findElement(By.xpath("(//hotel-name//name)[1]")).getText();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"hotel-card-0\"]/cta-wrapper/hotel-rate/cta-button")));
        driver.findElement(By.xpath("//*[@id=\"hotel-card-0\"]/cta-wrapper/hotel-rate/cta-button")).click();
        String roomType = driver.findElement(By.cssSelector("[class='room-title-row__title mb3']")).getText();
        if(roomType.equals("Standard Room"))
        {
	        String flexRate;
	        flexRate = driver.findElement(By.cssSelector("[class='rate-tile rate-tile--selected'] span[class='m0']")).getText();
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
