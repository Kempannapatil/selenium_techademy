package com.testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver;
  
	@Test
	public void launchBrowser() {
	 driver=new ChromeDriver();
		
		driver.manage().window().maximize();
	}
	@Test
	public void registerUser() {
		driver.get("https://demowebshop.tricentis.com/");
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/register']"))).click();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("FirstName")).sendKeys("kempanna");
		driver.findElement(By.id("LastName")).sendKeys("patil");
		driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
	}
	@Test
	public void selectBook() {
		driver.get("https://demowebshop.tricentis.com/books");
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/books'][1]"))).click();
		System.out.println(driver.getTitle());
		 
		driver.findElement(By.id("products-orderby")).sendKeys("A to Z");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/electronics']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/jewelry']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/create-it-yourself-jewelry']"))).click();
		 String price= driver.findElement(By.className("price-value-71")).getText();
		System.out.println(price);
		
		
		
	}
	
	
	
	
	
//	@AfterClass
//	 public void tearDown() {
//		 if(driver!= null) {
//			 driver.quit();
//		 }
	 }

	

