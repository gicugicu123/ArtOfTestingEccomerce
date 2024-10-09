package testBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass
{
	public WebDriver driver;
	public Logger logger; //Log4j
	
	@BeforeClass
	public void setup()
	{
		logger = (Logger) LogManager.getLogger(this.getClass());
		
		driver = new ChromeDriver();
		
		driver.get("https://ecommerce.artoftesting.com/");
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
