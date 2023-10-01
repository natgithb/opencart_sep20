package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
	
	//Constructor using super() 
	public HomePage(WebDriver driver) {
		super(driver); //invoked the parent class variable/methods/constructor
	}
	
		
	// Elements
	
	 @FindBy(xpath= "//span[normalize-space()='My Account']")  
	 WebElement lnkMyAccount;
	 
	 @FindBy(xpath= "//a[normalize-space()='Register']")  
	 WebElement lnkRegister;
	 
	 
	 @FindBy(linkText= "Login")  
	 WebElement lnkLogin;
	
		
	// Actions
	 
	 public void cMyAccount() {
		 lnkMyAccount.click(); 
	 }
	 
	 public void cRegister() {
		 lnkRegister.click(); 
	 }
	 
	 public void cLogin() {
		 lnkLogin.click(); 
	 }

}
