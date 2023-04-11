package com.crm.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage lp;
	HomePage hp;
	TestUtil tu;
	ContactsPage cp;
	
	String sn = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		tu = new TestUtil();
		cp=new ContactsPage();
		lp=new LoginPage();
		hp=lp.login(prop.getProperty("username"), prop.getProperty("password"));
		tu.switchToFrame();
	}
	
	@Test(priority =1 )
	public void contactsLableTest() {
		Assert.assertTrue(cp.contactsLable(), "Contacts lable is missing");
	}
	
	@Test(priority =2 )
	public void selectContactsTest() {
		cp=hp.clickContacts();
		cp.selectContacts("Ankit Patel");
	}
	@Test(priority =3 )
	public void selectMultipleContactsTest() {
		cp=hp.clickContacts();
		cp.selectContacts("Falak Pandya");
		cp.selectContacts("Harshit Gautam");
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sn);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void fillContactsFormTest(String title, String firstName, String lastName, String company){ 
		hp.clickOnNewContacts();
		cp.fillContactsForm(title, firstName, lastName, company);;
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
