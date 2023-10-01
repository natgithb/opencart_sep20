package tsetCases;

import testBase.BaseClass;
import utilities.DataProviders;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class LoginDDTest extends BaseClass {

	// If have the dataprovider in the same class, it is sufficient to specify only the 'dataProvider 
    // but we are using dataProvider in other class so we add additional parameter. 
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class) 
	public void test_loginDDT(String email, String password, String exp) { //pass parameters that comes from dataProvider
	
	logger.info("****  Starting TC_test_LoginDDTest  **** ");
	
	try {
		
		HomePage hp= new HomePage(driver);
		hp.cMyAccount();
		hp.cLogin();
				
		LoginPage lp=new LoginPage(driver);
		logger.info("****  Providing login details ");
		
// Previous session we take the data from properties data 		
	//	lp.setEmail(rb.getString("email"));
	//	lp.setPassword(rb.getString("password"));
		
// This session we take the data from dataProvider
		lp.setEmail(email);
		lp.setPassword(password);		
		lp.clickLogin();
		logger.info("****  Clicking on login button");
		
// Validation- consider positive and negative validation
		MyAccountPage maccp= new MyAccountPage(driver);
		boolean tragetpage= maccp.isMyAccountPageExists();// Enter to myaccount page
		
		if(exp.equals("valid")) { //getting from dataprovider(sheet)
			
			if(tragetpage==true) {
				
				maccp.clickLogout(); //In this point we successfully login, so have to do logout to move to the next user
				Assert.assertTrue(true);
			} else {
				Assert.fail(); // Assert.assertTrue(false);
			}			
		}
		
		if(exp.equals("invalid"))
		{
			if(tragetpage==true) {
					
					maccp.clickLogout(); //In this point we successfully login with invalid data so we have to logout
					Assert.fail();						
			} else {
				
				Assert.assertTrue(true);				
			}
			
		}
		
	} catch(Exception e) {
			Assert.fail();
	}
		
		logger.info("**** Finished LoginDDTest ****");
		
		
	}

}






