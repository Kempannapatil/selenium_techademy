package com.test.mylearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssElementselectors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.actitime.com/");
		
		List<WebElement> links=driver.findElements(By.cssSelector("a"));
		
		for(WebElement link:links) {
			String text=link.getText();
			if(!text.trim().isEmpty()) {
				System.out.println(link.getText());
				System.out.println(link.getAttribute("class"));
				System.out.println("------------------------------");
			}
			
		}
		driver.close();

	}

}
