package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scroll {
	
	AndroidDriver<AndroidElement> driver;
	public Scroll(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}
	
	public void scrollTotext(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}

}
