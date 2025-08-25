package day25;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(day25.MyTestListener.class)
public class ListernerTestClass {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    }

    @Test(priority = 1)
    public void validLoginTest() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']"))).click();

        // ✅ Wait for Dashboard to appear
        String dashBoardTitle = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']")))
                .getText();
        Assert.assertEquals(dashBoardTitle, "Dashboard", "Login failed!");
        driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout"))).click();
    }

    @Test(priority = 2)
    public void invalidLoginTest() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("WrongUser");
        driver.findElement(By.name("password")).sendKeys("WrongPass");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']"))).click();

        // ✅ Better locator
        String errorMessage = wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//p[contains(@class,'oxd-alert-content-text')]")))
                .getText()
                .trim();

        System.out.println("Error Message Displayed: " + errorMessage);

        // ✅ Assert ignoring case/extra spaces
        Assert.assertEquals(errorMessage, "Invalid credentials", "Error message mismatch!");
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();   // ✅ Quit only after all tests
        }
    }
}





