package com.nobtoker.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.nobroker.BaseTest.BaseClass;
import com.nobroker.pageobject.home.BuyPage;
import com.nobroker.pageobject.home.FeedBackPage;
import com.nobroker.pageobject.home.HomePage;
import com.nobroker.pageobject.home.Report;
import com.nobroker.pageobject.home.SuggestNEditPage;
import com.nobroker.pageobject.home.searchPropPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestCase extends BaseClass {
	static String city1;
	static String city2;
	static String expected;

	@BeforeTest
	public void loadProperty() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		city1 = prop.getProperty("city1");
		city2 = prop.getProperty("city2");
		expected = prop.getProperty("expected");
	}

	@Test
	public void reportIssue() throws InterruptedException, IOException {

		AndroidDriver<AndroidElement> driver = Capabilities();
		HomePage home = new HomePage(driver);
		// Switch to buy page and click on search button
		home.switchToBuy().editClick();
		// Select city and go the specific listed property (4th property)
		BuyPage bp = new BuyPage(driver);
		bp.sendCity1(city1, driver).selectCity1(driver).sendCity2(city2, driver).selectCity2(driver).incProperty()
				.selectTwoBHK().selectThreeBHK().search();
		// scroll to property and navigate to one and proceed for reporting the issue
		searchPropPage sp = new searchPropPage(driver);
		sp.scrollIntoProperty(driver).selectProperty().scrollTillWrongInfo(driver).selectWrngInfo();
		// now select reaons for wrong info and proceed towards reporting
		Report rp = new Report(driver);
		rp.selcectLocation().selectFakePhoto().selectBhkType().selectAvlDate().selectPrice().selectOther()
				.selectReport();
		// Now provide additional info on what went wrong and save changes
		SuggestNEditPage spage = new SuggestNEditPage(driver);
		spage.clickConfig().selectNewBHK().provideAdditionalInfo(driver).saveChanges();
		// now confirm the feedback message shown on the screen
		FeedBackPage fp = new FeedBackPage(driver);
		fp.confirmFeedBack(expected);
	}

}
