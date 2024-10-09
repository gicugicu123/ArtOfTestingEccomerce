package testBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass
{
	public WebDriver driver;
	public Logger logger; //Log4j
	
	@BeforeClass
	@Parameters({"browser", "os"})
	public void setup(String browser, String os)
	{
		logger = (Logger) LogManager.getLogger(this.getClass());
		
		switch (browser)
		{
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			
			default: logger.error("Invalid browser");
		}
		
		
		driver.get("https://ecommerce.artoftesting.com/");
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
