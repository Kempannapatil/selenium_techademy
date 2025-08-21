package com.test.mylearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProgrsm {
	
	WebDriver driver;
	@Test
	public void launchBrowser() throws Exception {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        Thread.sleep(2000);
        Assert.assertTrue( driver.findElement(By.xpath("//span[@class='gh-search-button__label']")).isEnabled(), "verify search button is enabled");
         driver.findElement(By.xpath("//span[@class='gh-search-button__label']")).click();
         Thread.sleep(1000);
         String expected="Shop by Category | eBay";
         String url=driver.getCurrentUrl();
         String title=driver.getTitle();
         //assertTrue checks exist or what
         //assertNotEquals opposite to equals
         //assert
         System.out.println(url);
         System.out.println(title);
         Assert.assertEquals(title, expected);
        
		
	}

}
