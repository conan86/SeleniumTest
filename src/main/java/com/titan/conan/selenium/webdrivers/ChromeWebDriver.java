package com.titan.conan.selenium.webdrivers;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	
	public void takeScreenshot(String screenshotDir) throws IOException{
		java.io.File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileName = screenshotDir + getScreenshotFileName();
		FileUtils.copyFile(screenshot,new File(fileName));
	}
	
	private String getScreenshotFileName() {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Random random = new Random();
		return df.format(new Date())+ + random.nextInt(10000)+".png";
	}
}
