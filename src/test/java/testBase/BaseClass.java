package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
	public static WebDriver driver;
	
	public Logger logger;
	
	public ResourceBundle rb;
	
	
	@BeforeClass(groups= {"Master","Sanity", "Regression"})
	@Parameters({"browser"})
	public void setup(String br) {
		
		rb=ResourceBundle.getBundle("config"); //Load config file
		
		logger= LogManager.getLogger(this.getClass()); //to get the current class we use getClass() to add the particular(this.) class to log file

		//driver=new ChromeDriver();	
		
		if(br.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver=new EdgeDriver();			
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//driver.get("https://demo.opencart.com/"); //live app		
		//driver.get("http://localhost/opencart/upload/"); //dev app
		driver.get(rb.getString("appURL2"));//dev app
				
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Master","Sanity", "Regression"})
	public void tearDown() {
		//driver.quit();		
	}
	
	public String randomString() { //Whenever calling this method a new string contains 5 characters
	 String generateString= RandomStringUtils.randomAlphabetic(5);	
	 return (generateString);
	}
	
	public String randomNumber() { //Whenever calling this method a new string contains 5 characters
		 String generateString2= RandomStringUtils.randomNumeric(10); //even generate number, its will takes as string format.
		 return (generateString2);
	}

	public String randomAlphaNumeric() { //Whenever calling this method a new string contains 5 characters
		
		String str= RandomStringUtils.randomAlphabetic(5);
		String num= RandomStringUtils.randomNumeric(10); 
		return (str+"@"+num); 
	}
	
	
	public String captureScreen(String tname) throws IOException {
		
		//Normal way to create time stamp(java)
		//SimpleDateFormat df= new SimpleDateFormat("yyyyMMddhhmmss"); // 1 new key is creating the object
		//Date dt= new Date(); //2
		//String timestamp=df.format(dt); //3
		
		//Short way to create time stamp
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE); //take the screenshot
        String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png"; // Store the screenshot with stamp time

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}
