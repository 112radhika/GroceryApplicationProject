package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	
	//ExtentReports - class help to generate report
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extentreports that can
	// be shared across the application

	public synchronized static ExtentReports createExtentReports() {

	ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html"); //format of report
	reporter.config().setReportName("7RMartSupermarketProject"); //setReportName - set name for report
	extentReports.attachReporter(reporter);

	extentReports.setSystemInfo("Organization", "Obsqura");
	extentReports.setSystemInfo("Name", " Radhika"); // provides context of the report
	return extentReports;

	}
	
	

}
