package com.capgemini.interview.hotelbooking;

import org.openqa.selenium.By;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HomePage {
	
	static DriverClient client;
	
	@Before
	public void setUp() {
		client = new DriverClient();
		client.driver.get(Config.Url.baseUrl);
		client.driver.manage().window().maximize();
		}
	
	@After
	public void tearDown() throws Exception{
		Thread.sleep(1000);
		client.clientTearDown(client.driver);
	}
	
	
	public void login(String uname, String pwd) throws Exception{
		Utilities.wait(By.linkText("Login"), client);
		client.driver.findElement(By.linkText("Login")).click();
		Utilities.wait(By.id("username"), client);
		client.driver.findElement(By.id("username")).sendKeys(uname);
		Utilities.wait(By.id("password"), client);
		client.driver.findElement(By.id("password")).sendKeys(pwd);
		Utilities.wait(By.id("doLogin"), client);
		client.driver.findElement(By.id("doLogin")).click();
		//Thread.sleep(5000);
	}
	
	
	public void enterUserName(String name) {
		client.driver.findElement(By.id("hotelName")).sendKeys(name);
	}
	
	public void enterAddress(String addr) {
		client.driver.findElement(By.id("address")).sendKeys(addr);
	}
	
	public void enterOwner(String owner) {
		client.driver.findElement(By.id("owner")).sendKeys(owner);
	}
	
	public void enterPhoneNumber(String phone) {
		client.driver.findElement(By.id("phone")).sendKeys(phone);
	}
	
	public void enterEmail(String email) {
		client.driver.findElement(By.id("email")).sendKeys(email);
	}
	
	public void clickCreate() {
		client.driver.findElement(By.id("createHotel")).click();
	}
	
	public void deleteHotel(String hotelToDelete) throws Exception {
		Utilities.wait(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/p"), client);
		
		int i = 2;
		boolean deleted = false;
		while(client.driver.findElements(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p")).size() !=0) {
		System.out.println("hotel:"+i+"is....." +client.driver.findElement(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p")).getText());
		String hotelName = client.driver.findElement(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p")).getText();
		if(hotelName.equalsIgnoreCase(hotelToDelete)) {
			System.out.println("hotel to delete is....." +client.driver.findElement(By.xpath("/html/body/div[1]/div["+i+"]/div[1]/div[1]/p")).getText());
			client.driver.findElement(By.xpath("/html/body/div[1]/div["+i+"]/div[2]/span")).click();
			deleted = true;
			Thread.sleep(1000);
		}
		else 
			i++;
		}
		if(!deleted)
			System.out.println("Hotel name not found! Nothing to delete");
	}
	
	
	
	
	
	

}
