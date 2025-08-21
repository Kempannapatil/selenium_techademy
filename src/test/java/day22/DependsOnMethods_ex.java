package day22;



import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DependsOnMethods_ex {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void openHomePage() {
        System.out.println("Step 1: Opened Home Page");
        String title = driver.getTitle();
        assert title.contains("Demo Web Shop");
    }

    @Test(dependsOnMethods = {"openHomePage"})
    public void clickLoginLink() {
        System.out.println("Step 2: Click login link");
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log in")));
        loginLink.click();
    }

    @Test(dependsOnMethods = {"clickLoginLink"})
    public void enterLoginDetails() {
        System.out.println("Step 3: Enter login details");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email"))).sendKeys("testuser@test.com");
        driver.findElement(By.id("Password")).sendKeys("test123");
    }

    @Test(dependsOnMethods = {"enterLoginDetails"})
    public void clickLogin() {
        System.out.println("Step 4: Click login button");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value='Log in']")));
        loginButton.click();
    }

    @Test(dependsOnMethods = {"clickLogin"})
    public void verifyLoginSuccess() {
        System.out.println("Step 5: Verify login success");
        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));
        String accountText = logoutLink.getText();
        assert accountText.equals("Log out");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


