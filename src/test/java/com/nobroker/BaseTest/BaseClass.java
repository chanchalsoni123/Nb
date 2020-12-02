package com.nobroker.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	static String device;
	static String id;

	@BeforeClass
	public static void loadProperties() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		device = prop.getProperty("device");
		id = prop.getProperty("device_udid");
	}

	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cp.setCapability(MobileCapabilityType.UDID, id);
		cp.setCapability("appPackage", "com.nobroker.app");
		cp.setCapability("appActivity", "com.nobroker.app.activities.NBSplashScreen");
		cp.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cp.setCapability(MobileCapabilityType.FULL_RESET, false);
		cp.setCapability(MobileCapabilityType.NO_RESET, true);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cp);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
}