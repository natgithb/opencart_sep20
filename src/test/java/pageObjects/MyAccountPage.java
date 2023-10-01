package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	//Constructor using super() 
	public MyAccountPage(WebDriver driver) {
		super(driver); }
	
	@FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") // MyAccount Page heading
	WebElement lnkLogout;

	
	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try { // Return if exist or not, we arn't doing validation here
			return (msgHeading.isDisplayed());
		} 
		catch (Exception e) 
		{
			return (false);
		}
	}
	
	
	public void clickLogout() {
		
		lnkLogout.click();
	}
	


}
