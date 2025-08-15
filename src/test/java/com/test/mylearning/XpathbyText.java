package com.test.mylearning;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathbyText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[text()='Email address or phone number']")).sendKeys("xyz");
		driver.findElement(By.xpath("//input[text()='Password']")).sendKeys("@123");
		driver.findElement(By.xpath("//button[text()='login']")).click();
		System.out.println(driver.getTitle());
		
	}

}
