package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy (name="username")
	WebElement userName;
	
	@FindBy (name="password")
	WebElement password;
	
	@FindBy (xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy (xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	@FindBy (xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String loginPageTitle() {
		return driver.getTitle();
	}
	public boolean crmImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pw) {
		userName.sendKeys(un);
		password.sendKeys(pw);
		loginButton.click();
		return new HomePage();
	}

}

