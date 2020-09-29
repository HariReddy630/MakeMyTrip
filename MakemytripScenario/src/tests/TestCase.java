package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.CommonMethods;
import framework.Data;
import framework.Locators;
import framework.PropertyData;
import framework.WebEvents;

public class TestCase {
	
	//End to end functionality automated in this method
	public static boolean makeMyTrip_end_to_end()  {
		try {
			Data.hm = PropertyData.properties(System.getProperty("user.dir")+"\\test-data\\Data.properties");
			CommonMethods.launchApplication(Data.hm.get("Browser"), Data.hm.get("URL"));
			Thread.sleep(5000);
			WebEvents.clickUsingActions(Locators.fromCity);
			WebEvents.enterValueIntoTexbox(Locators.fromCityTextbox, Data.hm.get("fromCity"), 50);
			WebEvents.selectValueInList(Locators.suggestCity, Data.hm.get("selectFromCity"));
			WebEvents.clickUsingActions(Locators.toCity);
			WebEvents.enterValueIntoTexbox(Locators.toCityTextBox,Data.hm.get("toCity"), 50);
			Thread.sleep(2000);
			WebEvents.selectValueInList(Locators.suggestCity, Data.hm.get("selectToCity"));
			WebEvents.clickUsingActions(Locators.departure);
			WebEvents.clickUsingActions(Locators.selectDate);
			WebEvents.clickUsingActions(Locators.searchBtn);
			Thread.sleep(2000);
			WebEvents.clickUsingActions(Locators.bookBtn);
			WebEvents.changeWindow();
			if(WebEvents.waitElementToBeFound(Locators.verifyText, 100).getText().equalsIgnoreCase(Data.hm.get("verifyText"))){
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	
	
	@BeforeTest
	public static void cleanup_Tasks() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");                         
	       
        Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

        Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
	}
	
	@Test
	public static  void testCase1() {
		
		Assert.assertTrue(makeMyTrip_end_to_end(), "testcase is failed.");
	}
	
	@AfterTest
	public static void close_browsers() {
		Data.driver.manage().deleteAllCookies();
		Data.driver.quit();
	}

}
