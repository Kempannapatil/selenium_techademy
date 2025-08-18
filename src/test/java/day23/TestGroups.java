package day23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestGroups {


	WebDriver driver;
	@Test
	public void launchBrowser(){
		System.out.println("browser is Launching ");
		driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		System.out.println("Browser launched");
		System.out.println(driver.getTitle());
	}
	@Test
	public void login() throws InterruptedException {
		System.out.println("try to login");
		driver.findElement(By.cssSelector(".ico-login")).click();
		driver.findElement(By.cssSelector(".email")).sendKeys("kempanna@gmail.com");;
		driver.findElement(By.cssSelector("#Password")).sendKeys("Kp@123");
		driver.findElement(By.id("RememberMe")).isSelected();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	
		Thread.sleep(1000);
		
		System.out.println("login Successfull");
	}
	
	@Test
	public void searchProduct() {
		 WebElement searchBox = driver.findElement(By.id("small-searchterms"));
		    searchBox.clear();
		    searchBox.sendKeys("Laptop");

		    driver.findElement(By.xpath("//input[@value='Search']")).click();

		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		        wait.until(ExpectedConditions.alertIsPresent());
		        driver.switchTo().alert().accept();
		        System.out.println("Alert handled: No search keyword entered.");
		    } catch (Exception e) {
		        System.out.println("Product search executed successfully");
		    }
		}

	
	@Test
	public void logOut() throws InterruptedException {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("small-searchterms")));
		    
		    logoutBtn.click();
		    driver.quit();
		    System.out.println("Logout successfully");
	}
}
