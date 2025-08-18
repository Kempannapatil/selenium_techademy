package com.test.mylearning;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cssselctors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver =new ChromeDriver();
		 driver.get("https://www.amazon.in/");
		 driver.manage().window().maximize();
	  System.out.println(	 driver.getTitle());
	  
	  driver.findElement(By.cssSelector("span.hm-icon-label")).click();
	  driver.findElement(By.partialLinkText("Alexa")).click();
	  driver.findElement(By.cssSelector("a.hmenu-item")).click();
	  driver.findElement(By.cssSelector("span.a-truncate-cut")).click();
	  String title= driver.findElement(By.cssSelector("span#productTitle")).getText();
	  System.out.println(title);
	  
	  if(title.contains("speaker with")) {
		  System.out.println("pass");
	  }
		  else
		  {
			  System.out.println("failed");
		  }
	  driver.close();
	  }
	  
	

	}


