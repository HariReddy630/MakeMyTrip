package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class CommonMethods {
public static void launchApplication(String browserName, String URL) {
		
		switch (browserName.toLowerCase()) {
		case "chrome": 
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			Data.driver = new ChromeDriver();
			break;
			
		case "firefox": 
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			Data.driver = new ChromeDriver();
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + browserName.toLowerCase());
		}
		
		Data.driver.get(URL);
		Data.driver.manage().window().maximize();
		Data.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}


