package day25;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	    private static ExtentReports extent;

	    public static ExtentReports getReporter() {
	        if (extent == null) {
	            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
	            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

	            reporter.config().setDocumentTitle("Automation Report");
	            reporter.config().setReportName("Selenium Test Results");
	            reporter.config().setTheme(Theme.STANDARD);

	            extent = new ExtentReports();
	            extent.attachReporter(reporter);

	            // Add system info
	            extent.setSystemInfo("Tester", "Your Name");
	            extent.setSystemInfo("Browser", "Chrome");
	            extent.setSystemInfo("OS", "Windows 11");
	        }
	        return extent;
	    }
	}


