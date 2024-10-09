package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M528.12 30')]")
	WebElement btnCart;
	
	@FindBy(xpath = "//span[normalize-space()='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//select[@class='Header_select__8rhX+']")
	WebElement dropdown;
	
	public void clickCart()
	{
		btnCart.click();
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public boolean isDropdownDisplayed()
	{
		return dropdown.isDisplayed();
	}
	
}
