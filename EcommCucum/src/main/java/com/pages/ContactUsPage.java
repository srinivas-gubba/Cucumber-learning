package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
	
	private WebDriver driver;
	
	private By name = By.id("input-name");
	private By email = By.id("input-email");
	private By query = By.id("input-enquiry");
	private By submit =  By.xpath("//*[@id=\"content\"]/form/div/div/input");  //By.className("btn btn-primary");	//*[@id="content"]/p
	private By sucessMessage = By.cssSelector("#content > p"); //By.xpath("//*[@id=\"content\"]/p");
			//By.id("content");
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public String getContactUsPageTitle() {
		return driver.getTitle();
	}
	
	public void fillContactUsPageform(String personName, String emailID, String querytext) {
		
		driver.findElement(name).sendKeys(personName);
		driver.findElement(email).sendKeys(emailID);
		driver.findElement(query).sendKeys(querytext);
		
	}
	
	public void clickSubmit() throws InterruptedException  {
		Thread.sleep(1000);
		driver.findElement(submit).click();
		
	}
	
	public String getSuccessMesssage() throws InterruptedException {
		
		//return driver.findElement(sucessMessage).getText();
		Thread.sleep(1000);
		
		  String message = driver.findElement(sucessMessage).getText();
		  
		  
		  System.out.println("message is :" +message); return message;
		 
	}

}
