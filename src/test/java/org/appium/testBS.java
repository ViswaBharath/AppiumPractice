package org.appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class testBS {

	// WebDriver driver;
	public static AndroidDriver driver;
	/*public static String userName = "archanacgaikwad_PG5Yvi";
	public static String accessKey = "17kdLByk3SjUprV1xqKy";*/

	public static String userName = "viswabharath_rQUBvH";
	public static String accessKey = "kXYNEq8yLKrCSTE5wkrb";

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

		caps.setCapability("app", "bs://aa8d7efbb6d5be60e69cfbdb489f76e6426e7149");
//		caps.setCapability("app", "bs://e7a7fc83aee8d7beb9bf1d06e3c365f11447e1f7");
		// Specify deviceName and platformName for testing
		caps.setCapability("platformName", "android");
		caps.setCapability("platformVersion", "12.0");
		caps.setCapability("deviceName", "Google Pixel 5");
		//AndroidDriver driver = new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"),caps);
		driver = new AndroidDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
	}



	@Test
	public void testSearchAppium() throws InterruptedException {
		System.out.println("Test Execution Started");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Test Appium");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//		AssertJUnit.assertEquals(toastMessage,"Please enter your name");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}



}