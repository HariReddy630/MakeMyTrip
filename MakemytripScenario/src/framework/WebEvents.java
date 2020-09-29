package framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WebEvents {
	public static WebElement waitElementToBeFound(By by, int timeOut) {
		WebElement ele ;
		try {
			WebDriverWait wait = new WebDriverWait(Data.driver, timeOut);
			wait.pollingEvery(Duration.ofMillis(200));
			ele = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			
			return ele;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	public static boolean isVisable(WebElement ele, int timeOut) {
		
		try {
			WebDriverWait wait = new WebDriverWait(Data.driver, timeOut);
			wait.pollingEvery(Duration.ofMillis(200));
			ele = wait.until(ExpectedConditions.visibilityOf(ele));
			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static boolean isEnable(WebElement ele, int timeOut) {
			
			try {
				WebDriverWait wait = new WebDriverWait(Data.driver, timeOut);
				wait.pollingEvery(Duration.ofMillis(200));
				ele = wait.until(ExpectedConditions.elementToBeClickable(ele));
				
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
	}
	
	public static void clickElement(By by,int timeOut) {
		WebElement e = waitElementToBeFound(by, timeOut);
		if(e!=null) {
			
			if(isVisable(e, timeOut)) {
				
				if(isEnable(e, timeOut)) {
					
					e.click();
					
				}else {
					Assert.assertTrue(false, "Unable to button not clickble and it's disabled");
				}
				
			}else {
				Assert.assertTrue(false, "Unable to button not clickble and it's not visable on the DOM");
			}
			
		}else {
			Assert.assertTrue(false, "Unable to button not clickble");
		}
	}
	
	public static void enterValueIntoTexbox(By by,String value, int timeOut) {
		WebElement e = waitElementToBeFound(by, timeOut);
		if(e!=null) {
			
			if(isVisable(e, timeOut)) {
				
				if(isEnable(e, timeOut)) {
					
					e.clear();
					e.sendKeys(value);
					
				}else {
					Assert.assertTrue(false, "Unable to enter value to text filed and it's disabled");
				}
				
			}else {
				Assert.assertTrue(false, "Unable to enter value to text filed and it's not visable on the DOM");
			}
			
		}else {
			Assert.assertTrue(false, "Unable to enter value to text filed");
		}
	}
	
	public static void clickUsingActions(By by) {
		Actions a = new Actions(Data.driver);
		a.click(waitElementToBeFound(by, 80)).build().perform();;
	}
	
	public static void selectValueInList(By by, String value) {
		try {
			List<WebElement> allCityies = Data.driver.findElements(by);
			for(WebElement city : allCityies) {
				if(city.getText().contains(value)) {
					Thread.sleep(2000);
					city.click();
					break;
				}
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public static void changeWindow() {
		try {

	 for (String handle : Data.driver.getWindowHandles()) {
	 
	    Data.driver.switchTo().window(handle);}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
