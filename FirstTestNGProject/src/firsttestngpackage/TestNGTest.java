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

public class TestNGTest {
	public WebDriver driver;
	String baseURL = "http://demo.guru99.com/test/newtours/";
	String driverPath = "C:/selenium software/chromedriver.exe";
	String actual = null;
	String expected = null;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("launchung the browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void verifyHomepage() {
		System.out.println("verify home page title");
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test (priority = 1)
	public void RegisterTab() {
		System.out.println("go to Register");
		driver.findElement(By.linkText("REGISTER")).click();
		expected = "Register: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
	}
	
	@Test (priority = 0)
	public void SupportTab() {
		System.out.println("go to Support");
		driver.findElement(By.linkText("SUPPORT")).click();
		expected = "Under Construction: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
	}
	
	@AfterMethod
	public void goToHomepage() {
		System.out.println("go to home page");
		driver.findElement(By.linkText("Home")).click();
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("close the browser");
		driver.quit();
	}
}









