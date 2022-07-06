package firsttestngpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGFile {
	public WebDriver driver;
	
  @Test
  public void verifyHomepageTitle() {
      
     System.out.println("launching firefox browser"); 
     System.setProperty("webdriver.chrome.driver", "C:/selenium software/chromedriver.exe");
     driver = new ChromeDriver();
     driver.get("http://demo.guru99.com/test/newtours/");
     String expectedTitle = "Welcome: Mercury Tours";
     String actualTitle = driver.getTitle();
     Assert.assertEquals(actualTitle, expectedTitle);
     driver.quit();
 }
}
