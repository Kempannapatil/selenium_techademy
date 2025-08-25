 package day25;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MyTestListener implements ITestListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    // ✅ Setup ExtentReport
    private static ExtentReports createInstance() {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = "./reports/ExtentReport_" + timestamp + ".html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Test Execution Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }

    // 🔹 Screenshot utility
    private String takeScreenshot(WebDriver driver, String testName, String status) {
        String fileName = null;
        if (driver != null) {
            try {
                String dateFolder = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                String folderPath = "./screenshots/" + dateFolder + "/";
                File folder = new File(folderPath);
                if (!folder.exists()) folder.mkdirs();

                String timestamp = new SimpleDateFormat("HH-mm-ss").format(new Date());
                fileName = folderPath + testName + "_" + status + "_" + timestamp + ".png";

                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(fileName));

                System.out.println("📸 Screenshot saved: " + fileName);
            } catch (Exception e) {
                System.out.println("⚠️ Could not capture screenshot: " + e.getMessage());
            }
        }
        return fileName;
    }

    @Override
    public void onStart(ITestContext context) {
        extent = createInstance();
        System.out.println("=== Test suite started ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // ✅ must flush
        System.out.println("=== Test suite Finished ===");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName());
        testThread.set(test);
        System.out.println("🚀 Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        WebDriver driver = ((ListernerTestClass) result.getInstance()).driver;
        String path = takeScreenshot(driver, result.getName(), "PASSED");
        testThread.get().pass("✅ Test Passed").addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((ListernerTestClass) result.getInstance()).driver;
        String path = takeScreenshot(driver, result.getName(), "FAILED");
        testThread.get().fail(result.getThrowable()).addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().skip("⏭️ Test Skipped: " + result.getName());
    }
}

