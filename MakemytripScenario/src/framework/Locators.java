package framework;

import org.openqa.selenium.By;

public class Locators {
	public static By fromCity = By.xpath("//input[@id='fromCity']");
	public static By toCity = By.xpath("//input[@id='toCity']");
	public static By fromCityTextbox = By.xpath("//input[@placeholder='From']");
	public static By toCityTextBox = By.xpath("//input[@placeholder='To']");
	public static By suggestCity = By.xpath("//p[text()='SUGGESTIONS ']/following::li/div/div");
	public static By departure = By.xpath("//span[text()='DEPARTURE']");
	public static By selectDate = By.xpath("//div[@aria-label='Sun Oct 04 2020']");
	public static By searchBtn = By.xpath("//a[text()='Search']");
	public static By bookBtn = By.xpath("//button[text()='Book Now']");
	public static By verifyText = By.xpath("//h4[text()='Review your booking']"); 
	public static By viewPrices =  By.xpath("//button[text()='View Prices']");
	public static By viewPricesBookBtn = By.xpath("//div[text()='Low Fare']/following::div/button[text()=' Book Now ']");

}
