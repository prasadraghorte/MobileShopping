package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.Scroll;

public class LoginPageObjects {
	
	AndroidDriver<AndroidElement> ldriver;
	
	public LoginPageObjects(AndroidDriver<AndroidElement> rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(new AppiumFieldDecorator(ldriver),this);
		ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement CountryDropdown;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter name here']")
	private WebElement Username;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement MaleRadio;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement FemaleRadio;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement LetsShop;
	
	Scroll scr = new Scroll(ldriver);
	private void selectCountry()
	{
		CountryDropdown.click();
		ldriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));").click();
	}
	
	private void enterUsername(String name)
	{
		Username.sendKeys(name);
		ldriver.hideKeyboard();
	}
	
	private void selectGender(String gender)
	{
		if(gender.equals("Male"))
		{
			MaleRadio.click();
		}
		if(gender.equals("Female"))
		{
			FemaleRadio.click();
		}
	}
	
	private void selectLogin()
	{
		LetsShop.click();
	}
	
	public void loginIntoTheApp(String UserName,String gender)
	{
		selectCountry();
		enterUsername(UserName);
		selectGender(gender);
		selectLogin();
	}
}
