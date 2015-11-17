package com.titan.conan.selenium.abstracts;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.titan.conan.selenium.interfaces.ISeleniumUtils;

public abstract class AbstractSeleniumUtils implements ISeleniumUtils{

	protected WebDriver driver;
	@Override
	public boolean elementExist(By by) {
		if(driver != null){
			try{
				driver.findElement(by);
			}catch(NoSuchElementException e) {
				return false;
			}
		} 
		return true;
	}

	@Override
	public WebElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}

	@Override
	public WebElement findElementByName(String name) {
		return driver.findElement(By.name(name));
	}

	@Override
	public WebElement findElementByLinkText(String linkText) {
		return driver.findElement(By.linkText(linkText));
	}

	@Override
	public WebElement findElementByCssName(String cssName) {
		return driver.findElement(By.className(cssName));
	}

	@Override
	public WebElement findElementByXPath(String xPath) {
		return driver.findElement(By.xpath(xPath));
	}

	@Override
	public void typeInputFieldWithClear(By by, String keysToSend) {
		WebElement inputFieldElement = driver.findElement(by);
		inputFieldElement.clear();
		inputFieldElement.sendKeys(keysToSend);
	}

	@Override
	public void typeInputFieldsWithClear(LinkedHashMap<By, String> inputFiledsInfo) {
		for(By key:inputFiledsInfo.keySet() ) {
			WebElement inputFieldElement = driver.findElement(key);
			inputFieldElement.clear();
			inputFieldElement.sendKeys(inputFiledsInfo.get(key));
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
	
}
