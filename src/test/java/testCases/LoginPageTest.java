package testCases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.LoginPageObjects;

public class LoginPageTest extends BaseClass{
	
	@Test
	public void login() throws MalformedURLException
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = setCapabilities();
		
		
		LoginPageObjects loginObj = new LoginPageObjects(driver);
		
		loginObj.loginIntoTheApp("Prasad", "Male");
		service.stop();
		/*
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();*/
	}
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}

}
