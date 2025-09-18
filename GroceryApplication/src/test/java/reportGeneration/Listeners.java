package reportGeneration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReportUtility;

public class Listeners implements ITestListener {
	//ExtentReportUtility is configured/called in Listeners
	 ExtentTest test;
	 ExtentReports extent = ExtentReportUtility.createExtentReports(); 
	 ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
//ITestListener - interface
//onTestStart,onTestSuccess etc methods in ITestListener
	 public void onTestStart(ITestResult result) {
//onTestStart invokes automatically before test execution. Fetch the name of the method and attach to the report.
	 ITestListener.super.onTestStart(result);
	 test = extent.createTest(result.getMethod().getMethodName());
	 extentTest.set(test);

	 }

	 public void onTestSuccess(ITestResult result) {
//onTestSuccess invokes when the testcase is passed. 
	 ITestListener.super.onTestSuccess(result);
	 extentTest.get().log(Status.PASS, "Test Passed");

	 }

	 public void onTestFailure(ITestResult result) {
	//onTestFailure invokes when the testcase is failed. 
	 ITestListener.super.onTestFailure(result);

	 extentTest.get().log(Status.FAIL, "Test Failed");
	 extentTest.get().fail(result.getThrowable());

	 WebDriver driver = null;

	 String testMethodName = result.getMethod().getMethodName();

	 try {

	 driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	 .get(result.getInstance());
	 } catch (IllegalArgumentException e) {

	 e.printStackTrace(); //reason for failure will be printed in reports
	 } catch (IllegalAccessException e) {

	 e.printStackTrace();
	 } catch (NoSuchFieldException e) {

	 e.printStackTrace();
	 } catch (SecurityException e) {

	 e.printStackTrace();
	 }

	 try {
	 driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	 .get(result.getInstance());
	 } catch (Exception e) {
	 }
	 }

	 public void onTestSkipped(ITestResult result) {
//onTestSkipped invokes when the testcase is skipped.
	 ITestListener.super.onTestSkipped(result);
	 extentTest.get().log(Status.SKIP, "Test Skipped");
	 String testMethodName = result.getMethod().getMethodName();

	 }

	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	 ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	 }

	 public void onTestFailedWithTimeout(ITestResult result) {

	 ITestListener.super.onTestFailedWithTimeout(result);
	 }

	 public void onStart(ITestContext context) {

	 ITestListener.super.onStart(context);
	 }

	 public void onFinish(ITestContext context) {
//flush - ensures proper execution of above cases and logged into report. report won't be generated properly if flush is not used
	 ITestListener.super.onFinish(context);
	 extent.flush();
	 }
	

}
