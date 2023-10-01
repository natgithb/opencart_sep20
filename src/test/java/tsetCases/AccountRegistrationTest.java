package tsetCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"Regression","Master"})
	void test_account_Registeration() throws InterruptedException {
		
		logger.debug("application logs..."); // debug is for developers
		
		logger.info("***  Starting TC_test_account_Registeration"); // for testers
		
	try {
			HomePage hp= new HomePage(driver);
			hp.cMyAccount();
			logger.info("Click on myaccount link");
			
			
			hp.cRegister();	
			logger.info("Click on register link");
			
			RegistrationPage arp= new RegistrationPage(driver);
			
			logger.info("Providing customres data");
			arp.setFN("Shiran");
			arp.setLN("Kasay");
			
			//arp.setEmail("d@gmail.com"); // Hard code data
			arp.setEmail(randomString()+"@gmail.com");
			
			arp.setTel("053-8899661");
			
			String password=randomAlphaNumeric();
			arp.setPass(password);
			Thread.sleep(1000);			
			arp.setConifPass(password);

			arp.setPrivacyPolicy();
			Thread.sleep(1000);
									
			arp.clickSub();
			logger.info("Click on continue");
			
						
			// Validation msg
			
			String confmsg= arp.getConfirmationMsg();
			
			logger.info("Vlaidate expected message");
			Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Test failed");
		//	Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed");
						
	}catch (Exception e) {
			logger.error("Test failed");
			Assert.fail();		
		}
	logger.info("***  Finished TC_test_account_Registeration");

  }
	
}











