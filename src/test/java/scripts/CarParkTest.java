package scripts;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.BaseTest;



public class CarParkTest  {
	
	public WebDriver driver = null;
	String sAbsPath = null;
	public static ExtentReports extent =null;
	public static ExtentTest logger = null;

	@BeforeMethod
	public void beforeMethod() {
		  
		  	System.out.println("Inside beforeMethod");
		  	sAbsPath = System.getProperty("user.dir");
		  	System.out.println("Absolute path: " + sAbsPath);
		  	extent = new ExtentReports(sAbsPath+"\\"+"CarParkExtentReports.html");
		
		
			//	System.setProperty("webdriver.chrome.driver",
			//			sAbsPath + "\\drivers\\chromedriver_win32\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", "D:\\selenium_softwares\\chromedriver_win32\\chromedriver.exe");
				
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("no-sandbox");
				//Fix for cannot get automation extension
				chromeOptions.addArguments("disable-extensions");
				chromeOptions.addArguments("--start-maximized");

			//	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				driver = new ChromeDriver(chromeOptions);
				driver.manage().window().maximize();
				//driver.get("http://192.168.0.211/CarParkWeb/CarPark.aspx");
				//driver.get("http://localhost:82/MyWebApp2/CarParkWeb/CarPark.aspx");
				driver.get("https://www.google.com");
				
				System.out.println("Running on chrome");
				
				//IE
				/*
			  	System.setProperty("webdriver.ie.driver", sAbsPath + "\\drivers\\IEDriverServer_Win32_2.44.0\\IEDriverServer.exe");
		    	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		    	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		    	capabilities.setCapability("ignoreZoomSetting", true);
		    	capabilities.setCapability("ignoreProtectedModeSettings" , true);
		    	capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://192.168.0.211/CarParkWeb/CarPark.aspx");
		    	driver = new InternetExplorerDriver(capabilities);
		    	*/
				
				//firefox
				/*

		  	driver = new FirefoxDriver();
		  	driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    driver.get("http://192.168.0.211/CarParkWeb/CarPark.aspx");
		    this.wait = new WebDriverWait(driver,60);
			*/
		}
@Test(priority=1)
public void carParkTest() throws Exception {
	
	
	
	try {
			logger = extent.startTest("CarParkTest");
			/*
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
			*/
			File file = new File(sAbsPath + "test" + ".png");
			System.out.println("File path : " + sAbsPath + "File id : " + file);
			Thread.sleep(4000);
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Thread.sleep(4000);
			System.out.println("Absolute path inside test method..");
			String dest = sAbsPath+ "\\ExtentScreenShots\\" + "GoogleHomePage"+" .png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot Taken");
				
			System.out.println("Extent Report Run Status : " + logger.getRunStatus());
			logger.log(LogStatus.INFO, "CarParkTest", "Success updated..");
			System.out.println("Description & Test : " + logger.getDescription() + " " + logger.getTest());
			String img = logger.addScreenCapture(dest);
		    logger.log(LogStatus.PASS,"CarParkTest passed", img);
		    System.out.println("Extent started ended at : " + logger.getStartedTime());
		    
		       
			
			
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
	  	extent.flush();
	  	System.out.println("After flushing..");
	  	driver.quit();
	  	System.out.println("Extent Report Run Status : " + logger.getRunStatus());
	  	//driver.close();
	 
	}
}