package tsetCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoinTest extends BaseClass{
	
	
	@Test(groups= {"Sanity","Master"})
	void test_login() {
		
		try{
		
		logger.info("****  Starting TC_test_LoinTest  **** ");
		
		HomePage hp= new HomePage(driver);
		hp.cMyAccount();
		hp.cLogin();
				
		LoginPage lp=new LoginPage(driver);
		logger.info("****  Providing login details ");
		
		lp.setEmail(rb.getString("email")); //rb--> Load the config file that hold email and password data
		lp.setPassword(rb.getString("password"));
		
		lp.clickLogin();
		logger.info("****  Clicking on login button");
		
		MyAccountPage maccp= new MyAccountPage(driver);
		boolean tragetpage= maccp.isMyAccountPageExists();
		Assert.assertEquals(tragetpage, true);
				
		} catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**** Finished LoinTest ****");
	}

}
