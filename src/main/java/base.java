import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		prop= new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\Sneha Sanket Shinde\\TestNGProject\\TechnicalAssessment\\src\\main\\java\\Whitbread\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if (browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","webdrivers/chromedriver.exe");
			driver = new ChromeDriver(); //initialize webdriver
		}
		else if (browserName.equals("FireFox")){
            System.setProperty("webdriver.gecko.driver","webdrivers/geckodriver.exe");
            driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		return driver;
	}

}
