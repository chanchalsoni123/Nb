package com.nobroker.pageobject.home;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Report {
	
	public Report(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	//searchBox
	@AndroidFindBy(id = "com.nobroker.app:id/cb_location")
	private AndroidElement location;
	
	@AndroidFindBy(id = "com.nobroker.app:id/cb_fake_photos")
	private AndroidElement fakePhoto;
	
	@AndroidFindBy(id = "com.nobroker.app:id/ll_bhk_type")
	private AndroidElement bhkType;
	
	@AndroidFindBy(id = "com.nobroker.app:id/cb_availability_date")
	private AndroidElement avlDate;
	
	@AndroidFindBy(id = "com.nobroker.app:id/cb_price")
	private AndroidElement price;
	
	@AndroidFindBy(id = "com.nobroker.app:id/cb_other")
	private AndroidElement other;
	
	@AndroidFindBy(id = "com.nobroker.app:id/btn_report")
	private AndroidElement report;
	
	public Report selcectLocation()
	{
		location.click();
		return this;
	}
	
	
	public Report selectFakePhoto()
	{
		fakePhoto.click();
		return this;
	}
	
    public Report selectBhkType()
    {
    	bhkType.click();
    	return this;
    }
	
    public Report selectAvlDate()
    {
    	avlDate.click();
    	return this;
    }
    
    public Report selectPrice()
    {
    	price.click();
    	return this;
    }
    public Report selectOther()
    {
    	other.click();
    	return this;
    }
    
    public Report selectReport()
    {
    	report.click();
    	return this;
    }
    

}
