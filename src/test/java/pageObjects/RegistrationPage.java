package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {
	
	//Constructor using super() method
	
	public RegistrationPage(WebDriver driver) {
		super(driver); //invoked the parent class variable/methods/constructor
		
	}

	 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	
	
	//Elements
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtRegister; 
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlastname; 
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail; 
	
	@FindBy(name = "telephone")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword; 

	@FindBy(name = "confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(name = "agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnsubmit; 

	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation; 
	
	
	
	//Actions
	
	public void setFN(String name) {
		txtRegister.sendKeys(name);
	}
		
	public void setLN(String lname) {
		txtlastname.sendKeys(lname);
	}
		
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void setTel(String phone) {
		txtTelephone.sendKeys(phone);
	}
		
	public void setPass(String pass) {
		txtpassword.sendKeys(pass);
	}
	
	public void setConifPass(String cpass) {
		txtConfirmPassword.sendKeys(cpass);
	}
	
		
 /*   public void rbNewsyes() {
    	
        // Wait for the element to be clickable
        WebElement clickableRbyes = wait.until(ExpectedConditions.elementToBeClickable(rbyes));

        // Click the element
        clickableRbyes.click();
    }*/

	
	public void setPrivacyPolicy() {
		
	  //WebElement clickableRbyes = wait.until(ExpectedConditions.elementToBeClickable(chkdPolicy));
	  // clickableRbyes.click();
		

        // Wait for the checkbox to be clickable
        WebElement clickableChkdPolicy = wait.until(ExpectedConditions.elementToBeClickable(chkdPolicy));

        // Use JavaScript Executor to force-click the checkbox
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", clickableChkdPolicy);
  				
	}
	
	public void clickSub() { 
		
		//sol1
		//btnsubmit.click();
		
		//sol2
		
        // Wait for the checkbox to be clickable
       // WebElement clickableSub = wait.until(ExpectedConditions.elementToBeClickable(btnsubmit));

        // Use JavaScript Executor to force-click the checkbox
       // JavascriptExecutor executor = (JavascriptExecutor) driver;
       // executor.executeScript("arguments[0].click();", clickableSub);
        
        
		//sol3- expliciti
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(btnsubmit)).click();
        
		
	}
	
	// This is not a validation method but an action method.
	// We made the confirmation of msg displaying(could be present or not)
	// here before validate it on tests class.
	
		
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
		
}
