package testCases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	public static AndroidDriver <AndroidElement>driver;
	public static AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startServer()
	{
		boolean flag = checkIfServerIsRunning(4723);
		if(!flag)
		{
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port)
	{
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		}
		catch(IOException e)
		{
			//if control comes here it means the port is in use
			isServerRunning = true;
		}
		finally
		{
			serverSocket=null;
		}
		return isServerRunning;
	}
	
	protected static AndroidDriver<AndroidElement> setCapabilities() throws MalformedURLException
	{
		File f = new File("src");
		File fis = new File(f,"General-Store.apk");
		String appPath = fis.getAbsolutePath();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, appPath);
		driver = new AndroidDriver<AndroidElement> (new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
	}
	
	public static void takeScreenshot(String testname) throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcFile, new File("C:\\Users\\prasa\\eclipse-workspace\\mobileShopping\\Screenshots\\"+testname+".png"));
	}

}
