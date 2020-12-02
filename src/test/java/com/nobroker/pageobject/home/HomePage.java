package com.nobroker.pageobject.home;


import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	public HomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	//Element Buy on the home page
	@AndroidFindBy(id = "com.nobroker.app:id/buyLayoutText")
	private AndroidElement Buy;

	//EditSearch Button on the home page 
	@AndroidFindBy(id = "com.nobroker.app:id/searchEditHome")
	private AndroidElement Edit;
	
	
	//Switch to buy page
	public HomePage switchToBuy()
	{
		Buy.click();
		return this;
	}
	
	public HomePage editClick()
	{
		Edit.click();
		return this;
	}
}
