package com.singtel.todo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtils {
	
	private static WebDriver webDriver;

	public static WebDriver getWebDriver() {
		if (webDriver != null) {
			return webDriver;
		}
		PropertyUtils.loadProperties();
		String browser = PropertyUtils.getPropertyByName(Constants.DEFAULT_BROWSER);
		if (browser.equalsIgnoreCase(Constants.CHROME)) {
			webDriver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase(Constants.FIREFOX)) {
			webDriver = new FirefoxDriver();
		}
		return webDriver;
	}

	public static void closeWebDriver() {
		if(webDriver!=null)
			webDriver.close();
	}

}
