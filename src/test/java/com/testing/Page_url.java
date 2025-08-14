package com.testing;

import org.openqa.selenium.chrome.ChromeDriver;

public class Page_url {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver=new ChromeDriver();
		  driver.get("https://www.google.com");
		System.out.println(   driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		//System.out.println(driver.getPageSource());
		System.out.println(driver.getWindowHandle());

	}

}
