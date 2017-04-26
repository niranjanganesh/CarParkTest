package scripts;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import utils.BaseTest;



public class CarParkTest  {
	
	public WebDriver driver = null;
	@BeforeMethod
	public void beforeMethod() {
		  
		  	System.out.println("Inside beforeMethod");
		  	String sAbsPath = System.getProperty("user.dir");
			System.setProperty("webdriver.ie.driver", sAbsPath + "\\drivers\\IEDriverServer_Win32_2.44.0\\IEDriverServer.exe");
	    	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	    	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	    	capabilities.setCapability("ignoreZoomSetting", true);
	    	capabilities.setCapability("ignoreProtectedModeSettings" , true);
	    	driver = new InternetExplorerDriver(capabilities);
	    	driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get("http://localhost/MyWebApp2/CarPark.aspx");
		    //this.wait = new WebDriverWait(driver,60);
			 
		}
@Test(priority=1)
public void pcidssAcquirerLogin() throws Exception {
	
	try {
			driver.findElement(By.id("txtShortDescription")).sendKeys("sd2short");
			Thread.sleep(2000);
			driver.findElement(By.id("txtLongDescription")).sendKeys("sd2long");
			//Select se1l = new Select(driver.findElement(By.id("ddlDataSource")));
			Thread.sleep(2000);
			driver.findElement(By.id("txtCapacity")).sendKeys("100");
			Thread.sleep(2000);
			driver.findElement(By.id("txtDisabledCapacity")).sendKeys("20");
			Thread.sleep(2000);
			driver.findElement(By.id("txtAlmostfullincreasing")).sendKeys("10");
			Thread.sleep(2000);
			driver.findElement(By.id("txtAlmostFullDecreasing")).sendKeys("10");
			Thread.sleep(2000);
			driver.findElement(By.id("txtFullIncreasing")).sendKeys("10");
			Thread.sleep(2000);
			driver.findElement(By.id("txtFullDecreasing")).sendKeys("10");
			Thread.sleep(2000);
			
			
			
			
			
			
			Thread.sleep(2000);
			Thread.sleep(2000);
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(2000);
			
	}catch (NoSuchElementException nse) {
		nse.printStackTrace();
		Assert.assertTrue(false);
	}
	catch (Exception e) {
		e.printStackTrace();
		Assert.assertTrue(false);
	}
	finally {
	    System.out.println("Inside finally block..");
	}
  }


@AfterMethod
public void afterMethod() throws InterruptedException {
	  
	  	System.out.println("Inside afterMethod");
	  	//driver.close();
	 
	}
}