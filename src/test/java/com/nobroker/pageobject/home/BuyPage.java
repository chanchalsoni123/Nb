package com.nobroker.pageobject.home;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class BuyPage {
	
	public BuyPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	//searchBox
	@AndroidFindBy(className = "android.widget.EditText")
	private AndroidElement searchBox;

	//NearBuy Properties
	@AndroidFindBy(id = "com.nobroker.app:id/nearByRadio")
	private AndroidElement nearByPrp;
	
	//Select 2BHK
	@AndroidFindBy(xpath = "//*[@text='2 BHK']")
	private AndroidElement twoBhk;
	
	//Select 3BHK
	@AndroidFindBy(xpath = "//*[@text='3 BHK']")
	private AndroidElement threeBhk;
	
	//Search Button
	@AndroidFindBy(xpath = "//*[@text='SEARCH']")
	private AndroidElement searchButton;
	
	//send city - Marathalli
	@SuppressWarnings("deprecation")
	public BuyPage sendCity1(String city1, AndroidDriver driver)
	{
		searchBox.click();
		searchBox.clear();
		driver.getKeyboard().sendKeys(city1);
		return this;
	}
	
	//send city -HSR Layout
	@SuppressWarnings("deprecation")
	public BuyPage sendCity2(String city2, AndroidDriver driver)
	{
		searchBox.click();
		searchBox.clear();
		driver.getKeyboard().sendKeys(city2);
	return this;
	}
	
	public BuyPage selectCity1(AndroidDriver driver) throws InterruptedException
	{
		  try {
			    Thread.sleep(13000);
			    TouchAction touchAction=new TouchAction(driver);
			    touchAction.tap(PointOption.point(411,825)).perform();
			     }
			     catch(ElementNotInteractableException e)
			     {
			    	 System.out.println(e);
			     }
		return this;
	}
	
	public BuyPage selectCity2(AndroidDriver driver) throws InterruptedException
	{   
		  try
		    {
		    Thread.sleep(1300); 
		    TouchAction touchAction=new TouchAction(driver);
		    touchAction.tap(PointOption.point(411,825)).perform(); 
		    }
		    catch(ElementNotInteractableException e)
		     {
		    	 System.out.println(e);
		     }
		return this;
		
	}
	
	public BuyPage incProperty() {
		
		 if(nearByPrp.isSelected())
		    {
		     System.out.println("Checkbox is already selected, contineue with the flow");
		    }
		    else
		    {
		    	nearByPrp.click();
		    }
		 return this;   
	}	
	
	
	public BuyPage selectTwoBHK()
	{
		twoBhk.click();
		return this;
	
	}
	
	public BuyPage selectThreeBHK()
	{
		threeBhk.click();	
		return this;
	}
	
	public BuyPage search()
	{
		searchButton.click();
		return this;
	}
	
	
}
