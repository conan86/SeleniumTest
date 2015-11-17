package com.titan.conan.selenium.test;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.titan.conan.selenium.interfaces.ISeleniumUtils;
import com.titan.conan.selenium.webdrivers.ChromeWebDriver;
import com.titan.conan.selenium.webdrivers.PhantomJSWebDriver;

import org.junit.Assert;
import junit.framework.TestCase;

public class LoginTest extends TestCase {

	private WebDriver driver;
	private ISeleniumUtils utils;
	private static final String WEB_DRIVER_NAME = "PHANTOMJS"; //PHANTOMJS : CHROME
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
		WebElement loginLink = driver.findElement(By.linkText("登录"));
		loginLink.click();
		WebElement baiduUserid = driver.findElement(By.id("TANGRAM__PSP_8__userName"));
		baiduUserid.clear();
		baiduUserid.sendKeys("nan125001930");
		WebElement baiduPassword = driver.findElement(By.id("TANGRAM__PSP_8__password"));
		baiduPassword.clear();
		baiduPassword.sendKeys("sxn_125001930");
		WebElement loginBtn = driver.findElement(By.id("TANGRAM__PSP_8__submit"));
		loginBtn.click();
		WebElement myCareDiv = driver.findElement(By.className("mine-text"));
		Assert.assertNotNull(myCareDiv);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
