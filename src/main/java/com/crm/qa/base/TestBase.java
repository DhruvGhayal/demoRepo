package com.crm.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		try {
		prop = new Properties();	
		FileInputStream fn = new FileInputStream("D:\\QA\\SeleniumWorkSpace\\FreeCRM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fn);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
		
		public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", "D:\\QA\\SeleniumJars\\chromedriver.exe");
			driver= new ChromeDriver();
		}else if (browserName.equals("Firefox")) {
			//System.setProperty("webdriver.gecko.driver", "D:\\QA\\SeleniumJars\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_time, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitly_wait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}

}
