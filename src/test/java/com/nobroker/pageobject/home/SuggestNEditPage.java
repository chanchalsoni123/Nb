package com.nobroker.pageobject.home;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SuggestNEditPage {

	public SuggestNEditPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	// selectBHK
	@AndroidFindBy(xpath = "//*[contains(@text,'BHK')]")
	private AndroidElement selectBHK;

	// new BHK Value
	@AndroidFindBy(xpath = "//*[contains(@text,'4+ BHK')]")
	private AndroidElement newBHK;

	// Additional Info
	@AndroidFindBy(id = "com.nobroker.app:id/edt_others")
	private AndroidElement additionalInfo;

	// Save Changes
	@AndroidFindBy(id = "com.nobroker.app:id/btn_save")
	private AndroidElement saveChanged;

	public SuggestNEditPage clickConfig() throws InterruptedException {
		Thread.sleep(4000);
		selectBHK.click();
		return this;

	}

	public SuggestNEditPage selectNewBHK() {
		newBHK.click();
		return this;
	}

	public SuggestNEditPage provideAdditionalInfo(AndroidDriver driver) 
	{


		Dimension dimension = driver.manage().window().getSize();
		int start2_x = (int) (dimension.width * 0.5);
		int start2_y = (int) (dimension.height * 0.8);

		int end2_x = (int) (dimension.width * 0.1);
		int end2_y = (int) (dimension.height * 0.001);

		TouchAction scrollObject2 = new TouchAction(driver);
		scrollObject2.press(PointOption.point(start2_x, start2_y))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end2_x, end2_y))
				.release().perform();

		additionalInfo.sendKeys("Room Info Was Wrong");
		return this;
	}
	
	public void saveChanges() {
		
		saveChanged.click();
	}

}
