package com.nobroker.pageobject.home;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FeedBackPage {
	
	
public FeedBackPage(AndroidDriver<AndroidElement> driver) {
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);

}

//feedBack
@AndroidFindBy(xpath = "//*[@text='Thank you for the feedback']")
private AndroidElement getFeedbackData;

public FeedBackPage confirmFeedBack(String Expected)
{
	 String Actual= getFeedbackData.getText();
     Assert.assertEquals(Expected, Actual);
	return this;	
     
     
 
}


}