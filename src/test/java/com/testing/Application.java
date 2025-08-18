package com.testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
  
public class Application {
	WebDriver driver;
	@Test
    public void lauchFacebook() {
    	driver = new ChromeDriver();
    	driver.get("https://www.facebook.com/");
    	driver.manage().window().maximize();
    System.out.println(	driver.getTitle());
    	
    }
	@Test
	public void signUp() {
		driver.get("https://www.facebook.com/");
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(1000));
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("kempanna@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("patil");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='1']"))).click();
	    System.out.println(driver.getTitle());
	}
	
	
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
	
	 


