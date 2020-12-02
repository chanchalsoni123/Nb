package com.nobroker.pageobject.home;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class searchPropPage {
	
	
	public searchPropPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	//searchBox
	@AndroidFindBy(id = "com.nobroker.app:id/property_thumbnail")
	private List<AndroidElement> findProperty;
	
	//WrongInfo
	@AndroidFindBy(xpath = "//*[@text='Wrong Info']")
	private AndroidElement wrngInfo;
	
	public searchPropPage scrollIntoProperty(AndroidDriver driver)
	{
		  Dimension dimension = driver.manage().window().getSize();
		    int start_x= (int) (dimension.width*0.5);
		    int start_y= (int) (dimension.height*0.8);
		    
		    int end_x= (int) (dimension.width*0.1);
		    int end_y= (int) (dimension.height*0.001);
		    
		    TouchAction scrollObject= new TouchAction(driver);
		    scrollObject.press(PointOption.point(start_x,start_y))
		       .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		       .moveTo(PointOption.point(end_x,end_y)).release().perform();
		 return this;   
	}
	
	public searchPropPage selectProperty()
	{
		 for(AndroidElement el:findProperty)
		    {	
		    System.out.println(el.getId());
		    }
		 findProperty.get(1).click();
		return this;
	}
	
	
	public searchPropPage scrollTillWrongInfo(AndroidDriver driver) throws InterruptedException
	{   
		Thread.sleep(3000);
		Dimension dimension = driver.manage().window().getSize(); 
	    int start1_x= (int) (dimension.width*0.5);
	    int start1_y= (int) (dimension.height*0.9);
	    
	    int end1_x= (int) (dimension.width*0.1);
	    int end1_y= (int) (dimension.height*0.000001);
		TouchAction scrollObject= new TouchAction(driver);
		
		 for(int i=0; i<=2; i++)
		    {
		       scrollObject.press(PointOption.point(start1_x,start1_y))
		       .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		       .moveTo(PointOption.point(end1_x,end1_y)).release().perform();
		    }
		return this;
	}
	
	public searchPropPage selectWrngInfo()
	{
		wrngInfo.click();
		return this;
	}
	

}
