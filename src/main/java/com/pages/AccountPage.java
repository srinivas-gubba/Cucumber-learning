package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

	private WebDriver driver;
	
	private By accountSection = By.cssSelector("#content > ul:nth-child(2) > li > a");
	
	// Constructor to initialize the driver
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountSectionCount() {
		
		return driver.findElements(accountSection).size();
	}
	
	public List<String> getAccountsectionList() {
		
		List<String> accountList= new ArrayList<String>();
		List<WebElement> accountsHeaderList= driver.findElements(accountSection) ;
		for(WebElement e : accountsHeaderList) {
			String text = e.getText();
			System.out.println("Account sections Text is:" +text);
			accountList.add(text);
		}
		return accountList;
		
	}
}
