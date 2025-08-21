package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
  WebDriver driver;
 
  @BeforeClass
  public void launch() {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://demowebshop.tricentis.com/");
	  
  }
  @Test(dataProvider = "loginData")
  public void login(String email, String password) throws InterruptedException {
	  driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
	  Thread.sleep(1000);
	  
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
	  driver.findElement(By.cssSelector("input[value='Log in']")).click();
	  Thread.sleep(1000);
	  
	  if (driver.getPageSource().contains("Log out")) {
          System.out.println("✅ Login successful for: " + email);
          Assert.assertTrue(true);
      } else {
          System.out.println("❌ Login failed for: " + email);
          Assert.assertTrue(driver.getPageSource().contains("Login was unsuccessful."));
      }

     
	  
  }
  
  
  
  @DataProvider(name = "loginData")
  public Object[][] getdata(){
	  return new Object[][]{
			  {"testuser1@gmail.com", "password1"},
				  {"testuser2@gmail.com", "password2"},
		            {"Kempanna@gmail.com", "Kp@123"}
			  
	  };
	  
	  
	  
  }
  @AfterClass
  public void closeBrowser() {
      driver.quit();
  }
}
