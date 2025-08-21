package com.test.mylearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdownselection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/reg/");
	String y=	driver.findElement(By.id("day")).getAttribute("value");
	String x=	driver.findElement(By.id("month")).getAttribute("value");
	String z=	driver.findElement(By.id("year")).getAttribute("value");
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		  List<WebElement> m=driver.findElements(By.cssSelector("select#month>option"));
		for(WebElement month:m) {
			if(month.getText().trim().equals("Dec")) {
				month.click();
				break;
			}
		}

	}

}
