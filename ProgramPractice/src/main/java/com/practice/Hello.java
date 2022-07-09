package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hello {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/selenium software/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		System.out.println("test");
		System.out.println("test1");
	}

}
