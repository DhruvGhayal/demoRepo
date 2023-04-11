package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.crm.qa.base.TestBase;
public class ContactsPage extends TestBase{
	
	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLable;
	
	@FindBy (name="title")
	WebElement Title;
	
	@FindBy (id="first_name")
	WebElement firstName;
	
	@FindBy (id="surname")
	WebElement lastName;
	
	@FindBy (name="client_lookup")
	WebElement company;
	
	@FindBy (xpath="//input[@type='submit' and @value='Save']")
	WebElement save;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean contactsLable() {
		return contactsLable.isDisplayed();
	}
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	}
	public void fillContactsForm(String T,String FN, String LN, String C) {
		Select s = new Select(Title);
		s.selectByVisibleText(T);
		firstName.sendKeys(FN);
		lastName.sendKeys(LN);
		company.sendKeys(C);
		save.click();
	}
	
}
