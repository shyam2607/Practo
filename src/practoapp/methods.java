package practoapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class methods 
{
  public static AndroidDriver driver;
  public static String mail ="benrocks28@gmail.com";
  public static String password="practo123";
@Test
  

public void installation() throws MalformedURLException, InterruptedException 
  {
		// Created object of DesiredCapabilities class.
		  DesiredCapabilities capabilities = new DesiredCapabilities();

		  // Set android deviceName desired capability. Set your device name.
		  capabilities.setCapability("deviceName", "ZY223K962H");

		  // Set BROWSER_NAME desired capability. It's Android in our case here.
		  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

		  // Set android VERSION desired capability. Set your mobile device's OS version.
		  capabilities.setCapability(CapabilityType.VERSION, "6.0.1");

		  // Set android platformName desired capability. It's Android in our case here.
		  capabilities.setCapability("platformName", "Android");

		  // Set android appPackage desired capability. It is
		  // com.practo.droid for practo application.
		  capabilities.setCapability("appPackage", "com.practo.droid");

		  // Set android appActivity desired capability. It is
		  // com.practo.droid.account.splash.SplashActivity for practo application.
		  capabilities.setCapability("appActivity", "com.practo.droid.account.splash.SplashActivity");

		  // Created object of RemoteWebDriver will all set capabilities.
		  // Set appium server address and port number in URL string.
		  // It will launch calculator app in android device.
		  driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  Thread.sleep(5000);
  }
	
	
	
	
	public void home() throws InterruptedException
	{
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.practo.droid:id/next_btn']")).click();
		Thread.sleep(5000);
	}
	
	
	
	public void login() throws InterruptedException 
	{
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.practo.droid:id/login_btn']")).click();
		Thread.sleep(5000);
		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Login using email?']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.practo.droid:id/et_username']")).sendKeys(mail);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.practo.droid:id/et_password']")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.practo.droid:id/btn_submit']")).click();
		Thread.sleep(5000);
		
		
	}
	
	
	public void switchapp() throws InterruptedException
	{
	Thread.sleep(3000);
	driver.startActivity("com.google.android.apps.messaging","com.google.android.apps.messaging.ui.conversationlist.ConversationListActivity");
	Thread.sleep(4000);
	String s1=driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/conversation_snippet']")).getText();
	System.out.println(s1);
	//if(s1==driver.findElement(By.partialLinkText(linkText)))
	
	
	Thread.sleep(4000);
	}




	
	
	
}
