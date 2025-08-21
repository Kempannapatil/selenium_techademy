package day23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExcellTestng {
	  
	WebDriver driver;
	
	@Test(dataProvider="getExelData",dataProviderClass=ExcelldataProvider.class)
	public void login(String userName ,String password) throws InterruptedException {
		System.out.println("Launching the browser");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("Login with: "+userName+"/"+password);
		WebDriverWait wait= new  WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		Thread.sleep(2000);	
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));
			System.out.println("Login Successful"+userName);
			
		}
		catch(Exception e) {
			String errorMsg=driver.findElement(By.xpath("//p[contains(text(),'Invalid credentials')]")).getText();
			System.out.println("Login failed");
			Assert.fail("Login failed for user: "+userName);
			
		}
		driver.quit();
	}
	

}
