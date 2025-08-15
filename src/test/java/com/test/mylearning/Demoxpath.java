package com.test.mylearning;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demoxpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@ type='text']")).sendKeys("xyz");
		driver.findElement(By.xpath("//input[@ type='password']")).sendKeys("@123");
		driver.findElement(By.xpath("//button[@ value='1']")).click();
		System.out.println(driver.getTitle());
		

	}

}
