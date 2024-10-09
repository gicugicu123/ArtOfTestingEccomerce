package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class HomePageTest extends BaseClass
{	
	@Test
	public void isSelectDisplayed()
	{
		HomePage homePage = new HomePage(driver);
		boolean isDisplayed = homePage.isDropdownDisplayed();
		
		logger.info("Check that dropdown is displayed");
		Assert.assertEquals(isDisplayed, true);
	}
}
