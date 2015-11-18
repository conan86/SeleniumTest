package com.titan.conan.selenium.test;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.titan.conan.selenium.interfaces.ISeleniumUtils;
import com.titan.conan.selenium.webdrivers.ChromeWebDriver;
import com.titan.conan.selenium.webdrivers.PhantomJSWebDriver;

import org.junit.Assert;
import junit.framework.TestCase;

public class LoginTest extends TestCase {

	private WebDriver driver;
	private ISeleniumUtils utils;
	private static final String WEB_DRIVER_NAME = "CHROME"; //PHANTOMJS : CHROME
	@Before
	public void setUp() throws Exception {
		if(WEB_DRIVER_NAME.equals("CHROME")) {
			 utils = new ChromeWebDriver();
		        driver = utils.getWebDriver("src/main/resources/chromedriver.exe");
		}else {
			utils = new PhantomJSWebDriver();
	        driver = utils.getWebDriver("src/main/resources/phantomjs.exe");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testOpenBaidu() {
		driver.get("http://www.baidu.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		WebElement loginLink = utils.findElementByLinkText("登录");
		loginLink.click();
		LinkedHashMap<By,String> inputFiledsInfo = new LinkedHashMap<By,String>();
		inputFiledsInfo.put(By.id("TANGRAM__PSP_8__userName"), "nan125001930");
		inputFiledsInfo.put(By.id("TANGRAM__PSP_8__password"), "sxn_125001930");
		utils.typeInputFieldsWithClear(inputFiledsInfo);
		WebElement loginBtn = utils.findElementById("TANGRAM__PSP_8__submit");
		loginBtn.click();
		Assert.assertTrue(utils.elementExist(By.className("mine-text")));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
