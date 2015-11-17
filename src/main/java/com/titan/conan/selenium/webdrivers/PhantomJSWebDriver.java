package com.titan.conan.selenium.webdrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.titan.conan.selenium.abstracts.AbstractSeleniumUtils;

public class PhantomJSWebDriver extends AbstractSeleniumUtils {

	@Override
	public WebDriver getWebDriver(String driverPath) {
		DesiredCapabilities desireCaps = new DesiredCapabilities();
		desireCaps.setJavascriptEnabled(true);
		desireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "src/main/resources/phantomjs.exe");
		driver = new PhantomJSDriver(desireCaps);
		return driver;
	}

}
