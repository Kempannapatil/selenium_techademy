package com.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo2 {
	WebDriver driver;
	@Test
	public void LaunchBrowser() {
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
	     driver.get("https://web.whatsapp.com/");

		System.out.println(driver.getTitle());
	}
	
	

}
