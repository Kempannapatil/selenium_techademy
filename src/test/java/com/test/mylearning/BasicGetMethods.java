package com.test.mylearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicGetMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
  String att1=driver.findElement(By.id("u_0_8_uc")).getAttribute("class");
  String att2=driver.findElement(By.id("u_0_a_xK")).getAttribute("aria-label");
  String att3=driver.findElement(By.id("u_0_a_xK")).getTagName();
  System.out.println(att1);
  System.out.println(att2);
  System.out.println(att3);
	}

}
