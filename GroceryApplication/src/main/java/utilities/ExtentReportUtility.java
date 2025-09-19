package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	//ExtentReports - class help to generate report
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extentreports that can
	// be shared across the application

	public synchronized static ExtentReports createExtentReports() {
	//createExtentReports - static method, can be called without creating object of ExtentReportUtility
	//synchronized - ensures thread-safety (if multiple tests run in parallel, only one thread at a time can initialize the report).
	//ExtentSparkReporter - generates the HTML file of the report
	//"./extent-reports/extent-report.html - report will be stored in a folder named extent-reports
	ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //format of report
	reporter.config().setReportName("7RMartSupermarketProject"); //setReportName - set report name/title on dashboard
	extentReports.attachReporter(reporter); // Connects the Spark reporter with the main ExtentReports object.
	//Without this, the ExtentReports object doesn’t know where/how to generate the report.

	extentReports.setSystemInfo("Organization", "Obsqura");
	extentReports.setSystemInfo("Name", " Radhika"); //provides context of the report. Can view the details under the "Environment Details" section.
	return extentReports; //Returns the configured ExtentReports object so that tests can create test cases, log steps, attach screenshots, etc.

	}

}
