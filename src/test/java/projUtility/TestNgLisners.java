package projUtility;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.ITestListener;
public class TestNgLisners implements ITestListener {
	WebDriver driver= null;
	@Override  
	public void onTestStart(ITestResult result) {  
	// TODO Auto-generated method stub  
//		  try {
//			driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//			// TODO Auto-generated catch block
//			driver = LaunchBrowser.driver;
//			//e.printStackTrace();
//			System.out.println("Error getting web driver from test package in listner package");
//		}
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Success of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	try {
		LaunchBrowser lb = new LaunchBrowser();
		lb.TakeErrorScreanShort(driver, result.getName()+"__"+result.getStatus());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("error creating screenshort");
		e.printStackTrace();
	}
		
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onStart(ITestContext context) {  
	// TODO Auto-generated method stub 
		
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
	// TODO Auto-generated method stub
		driver=null;
	} 
}
