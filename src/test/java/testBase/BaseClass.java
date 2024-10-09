package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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
	public Properties prop;
	
	@BeforeClass
	@Parameters({"browser", "os"})
	public void setup(String browser, String os) throws IOException
	{
		//loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		
		prop = new Properties();
		prop.load(file);
		
		String appURL = prop.getProperty("appURL");
		
		logger = (Logger) LogManager.getLogger(this.getClass());
		
		switch (browser)
		{
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			
			default: logger.error("Invalid browser");
		}
		
		
		driver.get(appURL);
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
