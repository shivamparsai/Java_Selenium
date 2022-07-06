package firsttestngpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ThirdTestNGFile {
	public WebDriver driver;
	public String baseURL = "http://demo.guru99.com/test/newtours/";
	String driverPath = "C:/selenium software/chromedriver.exe";
	String expected = null;
	String actual = null;
	
  @BeforeTest
  public void launchBrowser() {
	  System.out.println("Before Test: Launching the Browser");
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  driver = new ChromeDriver();
	  driver.get(baseURL);
	  driver.manage().window().maximize();
  }
  
  @BeforeMethod
  public void verifyHomepageTitle() {
	  System.out.println("Before Method: Before every TC verifying home page title");
	  String expectedTitle = "Welcome: Mercury Tours";
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @Test(priority = 1)
  public void register() {
	  System.out.println("Test: Verifying Register home page");
	  driver.findElement(By.linkText("REGISTER")).click();
	  expected = "Register: Mercury Tours";
	  actual = driver.getTitle();
	  Assert.assertEquals(expected, actual);
  }
  
  @Test(priority = 0)
  public void support() {
	  System.out.println("Test: Verifying Support home page");
	  driver.findElement(By.linkText("SUPPORT")).click();
	  expected = "Under Construction: Mercury Tours";
	  actual = driver.getTitle();
	  Assert.assertEquals(expected, actual);	  
  }
  
  @AfterMethod
  public void goToTheHomePage() {
	  System.out.println("After Method: After every TC going to home page");
	  driver.findElement(By.linkText("Home")).click();
  }
  
  @AfterTest
  public void closeBrowser() {
	  System.out.println("After Test: At last closing the browser");
	  driver.quit();
  }
}

