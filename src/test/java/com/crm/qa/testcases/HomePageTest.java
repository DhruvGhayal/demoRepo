package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	TestUtil tu;
	ContactsPage cp;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		tu = new TestUtil();
		cp=new ContactsPage();
		initialization();
		lp=new LoginPage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority =1 )
	public void homePageTitleTest() {
		String homePageTitle = hp.homePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page title not match");
	}
	
	@Test(priority =2 )
	public void userNameDisplayTest() {
		tu.switchToFrame();
		Assert.assertTrue(hp.userNameDisplay());
	}
	@Test(priority =3 )
	public void clickContactsTest() {
		tu.switchToFrame();
		cp=hp.clickContacts();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
