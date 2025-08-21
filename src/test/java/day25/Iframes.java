package day25;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	import java.time.Duration;

	public class Iframes {
	    
	    WebDriver driver;
	    
	    @Test
	    public void launching() {
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://practice-automation.com/iframes/");
	        driver.manage().window().maximize();
	    }
	       @Test (priority=1)
	   public void iFrame1() throws InterruptedException {
	        WebElement iframe1=driver.findElement(By.id("iframe-1"));
	        driver.switchTo().frame(iframe1);
	        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".DocSearch.DocSearch-Button"))).click();
            Thread.sleep(3000);
            
            driver.findElement(By.className("DocSearch-Input")).sendKeys("wassup guys");
            driver.switchTo().defaultContent();
            
	    }
	     @Test(priority=2)  
	public void iFrame2() {
		WebElement iframe2=driver.findElement(By.id("iframe-2"));
		driver.switchTo().frame(iframe2);
		driver.findElement(By.xpath("//span[normalize-space()='Downloads']")).click();
		 driver.switchTo().defaultContent();
	}
	}
	

