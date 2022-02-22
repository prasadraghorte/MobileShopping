package utilities;

import org.testng.ITestListener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;

import testCases.BaseClass;


public class Listeners implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result)
	{
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String testName = result.getName();
		try {
			BaseClass.takeScreenshot(testName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}
	
	@Override
	public void onStart(ITestContext context)
	{
		
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		
	}

}
