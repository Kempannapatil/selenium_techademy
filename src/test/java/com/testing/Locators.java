package com.testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Locators {
   
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		
		  ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.name("field-keywords")).sendKeys("barbi dolls");
		
		driver.findElement(By.id("nav-search-submit-button")).click();
		 Thread.sleep(1000);
		 
		 driver.findElement(By.className("a-size-base")).click();
		 Thread.sleep(2000);
		 
		String title=driver.findElement(By.id("productTitle")).getText();
		 String price=driver.findElement(By.className("a-price-whole")).getText();
		 System.out.println("price: "+price);
		 System.out.println(title);
				
		
		

	}

}
