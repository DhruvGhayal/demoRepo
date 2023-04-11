package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	TestUtil tu;
	
	@FindBy (xpath="//td[contains(text(),'User: Dhruv Ghayal')]")
	WebElement userNameLable;
	
	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy (xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	public boolean userNameDisplay() {
		return userNameLable.isDisplayed();
	}
	public ContactsPage clickContacts() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDeals() {
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickTasks() {
		dealsLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContacts() {
		Actions builder = new Actions(driver);
		builder.moveToElement(contactsLink).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	}
}
