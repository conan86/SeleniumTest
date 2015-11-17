package com.titan.conan.selenium.interfaces;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ISeleniumUtils {
	public boolean elementExist(By by);
	public WebElement findElementById(String id);
	public WebElement findElementByName(String name);
	public WebElement findElementByLinkText(String linkText);
	public WebElement findElementByCssName(String cssName);
	public WebElement findElementByXPath(String xPath);
	public void typeInputFieldWithClear(By by,String keysToSend);
	public void typeInputFieldsWithClear(LinkedHashMap<By,String> inputFiledsInfo);
	public WebDriver getWebDriver(String driverPath);
}
