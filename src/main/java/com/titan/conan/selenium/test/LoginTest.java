package com.titan.conan.selenium.test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.titan.conan.selenium.interfaces.ISeleniumUtils;
import com.titan.conan.selenium.webdrivers.ChromeWebDriver;
import com.titan.conan.selenium.webdrivers.PhantomJSWebDriver;

import org.junit.Assert;
import junit.framework.TestCase;

public class LoginTest extends TestCase {

	private WebDriver driver;
	private ISeleniumUtils seleniumUtils;
	private static final String WEB_DRIVER_NAME = "PHANTOMJS"; //PHANTOMJS : CHROME
	@Before
	public void setUp() throws Exception {
		if(WEB_DRIVER_NAME.equals("CHROME")) {
			 seleniumUtils = new ChromeWebDriver();
		     driver = seleniumUtils.getWebDriver("src/main/resources/chromedriver.exe");
		}else {
			seleniumUtils = new PhantomJSWebDriver();
	        driver = seleniumUtils.getWebDriver("src/main/resources/phantomjs.exe");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testOpenBaidu() throws IOException {
		driver.get("http://www.baidu.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		WebElement loginLink = seleniumUtils.findElementByLinkText("登录");
		loginLink.click();
		LinkedHashMap<By,String> inputFiledsInfo = new LinkedHashMap<By,String>();
		inputFiledsInfo.put(By.id("TANGRAM__PSP_8__userName"), "nan125001930");
		inputFiledsInfo.put(By.id("TANGRAM__PSP_8__password"), "sxn_125001930");
		seleniumUtils.typeInputFieldsWithClear(inputFiledsInfo);
		WebElement loginBtn = seleniumUtils.findElementById("TANGRAM__PSP_8__submit");
		loginBtn.click();
		Assert.assertTrue(seleniumUtils.elementExist(By.className("mine-text")));
		if(seleniumUtils instanceof ChromeWebDriver ) {
			((ChromeWebDriver) seleniumUtils).takeScreenshot("src/main/resources/screenshots/");
		}
	}
	
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
