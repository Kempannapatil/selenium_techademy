package Day24;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_provider {
	
	WebDriver driver;
	@BeforeClass
	public void launchBrowser() {
		System.out.println("Launching the browser");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	@Test(dataProvider="loginTestData")
	public void login(String userName,String password) throws InterruptedException {
		System.out.println("Logging in");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
	}
	
	@DataProvider(name="loginTestData")
	 public Object[][] loginData(){
		Object[][] data =new Object[2][2];
		data[0][0]="Admin";
		data[0][1]="Admin123";
		data[1][0]="Admin";
		data[1][1]="Admin123";
		return data;
		}
	

}
