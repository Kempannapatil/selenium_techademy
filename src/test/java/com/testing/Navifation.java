package com.testing;

import org.openqa.selenium.chrome.ChromeDriver;

public class Navifation {
	public static void main(String[] args) {
		  ChromeDriver driver= new ChromeDriver();
		  driver.get("https:/www.google.com");
		 System.out.println( driver.getTitle());
		 driver.navigate().to("https:/www.facebook.com");
		 System.out.println(driver.getTitle());
		 
		 driver.navigate().back();
		 System.out.println(driver.getTitle());
		 driver.navigate().forward();
		 System.out.println(driver.getTitle());
		 driver.navigate().refresh();
		  
	}

}
