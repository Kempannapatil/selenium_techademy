package day23;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IgnoreTestCases {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void launchBrowser() {
        System.out.println("Browser is Launching");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        System.out.println("Browser Launched");
    }

    @Test(priority = 1)
    public void loginTest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")))
            .sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-topbar-header-breadcrumb")));
        System.out.println("Login Successful");
    }

    @Test(enabled = false)
    public void employeeSearch() {
        driver.findElement(By.cssSelector(".oxd-main-menu-item.active")).click();
        driver.findElement(By.name("empsearch[employee_name][empName]"))
              .sendKeys("Linda Anderson");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Search employee executed");
    }

    @Test(priority = 2)
    public void logOut() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("oxd-userdropdown-name")))
            .click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")))
            .click();
        System.out.println("Logout successfully");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}
