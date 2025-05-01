package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver; //instance variable
	
	private By emailID = By.id("input-email");
	private By password = By.id("input-password");
	private By signInButton = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
	private By forgotPwdLink = By.linkText("Forgotten Password3333");
	


	public LoginPage(WebDriver driver) {
		this.driver = driver; //Assigns the parameter to the instance variable i.e to this.driver 
		
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExists() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public void enterUsername(String username) {
		driver.findElement(emailID).sendKeys(username);
	}
	
	public void enterPwd(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		
		driver.findElement(signInButton).click();
	}
	public AccountPage doLogin(String un, String pwd) {
		System.out.println("username and passord is :" +un +" and "  +pwd);
		driver.findElement(emailID).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		
		driver.findElement(signInButton).click();
		return new AccountPage(driver);
	}

}
