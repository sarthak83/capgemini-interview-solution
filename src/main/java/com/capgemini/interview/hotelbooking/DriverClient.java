package com.capgemini.interview.hotelbooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class DriverClient {
	
	public WebDriver driver;
	
	public DriverClient() {
		driver = getDriver();
	}

	public WebDriver getDriver() {
		switch(Config.Ui.browser) {
		case Chrome: 
			System.setProperty("webdriver.chrome.driver", "/Users/sarthakdayanand/Documents/Automation/chromedriver");
			return new ChromeDriver();
		
		case Firefox:
			System.setProperty("webdriver.firefox.bin", "/Applications/IBM Firefox.app/Contents/MacOS/firefox-bin");
		    return new FirefoxDriver();
	
		
		case Safari:
		return new SafariDriver();
		
		default: 
		return null;
			
		
		}
	}
	
	public void clientTearDown(WebDriver vardriver) {
		vardriver.close();
	}

}
