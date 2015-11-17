package com.titan.conan.selenium.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.titan.conan.selenium.abstracts.AbstractSeleniumUtils;


public class ChromeWebDriver extends AbstractSeleniumUtils{

	@Override
	public WebDriver getWebDriver(String driverPath) {
		System.setProperty("webdriver.chrome.driver",driverPath);
		DesiredCapabilities desireCaps = DesiredCapabilities.chrome();
		desireCaps.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,driverPath);
		driver = new ChromeDriver(desireCaps);
		return driver;
	}
	
}
