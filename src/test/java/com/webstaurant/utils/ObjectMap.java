package com.webstaurant.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	public Properties prop;

	public ObjectMap(String path) {

		prop = new Properties();

		try (FileInputStream orangeHRMfileInputStream = new FileInputStream(path)) {

			prop.load(orangeHRMfileInputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public By getLocator(String strElement) {

		String locator = "";
		String locatorType = "";
		String locatorValue = "";

		try {

			locator = prop.getProperty(strElement);
			locatorType = locator.split(":")[0].trim();
			locatorValue = locator.substring(locator.indexOf(":") + 1).trim();
		} catch (Exception e) {
			System.out.println("Following element is not in the list of existing properties" + strElement);

		}

		By byId = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			byId = By.id(locatorValue);
			break;
		case "name":
			byId = By.name(locatorValue);
			break;
		case "tagname":
		case "tag":
			byId = By.tagName(locatorValue);
			break;
		case "linktext":
		case "link":
			byId = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			byId = By.partialLinkText(locatorValue);
			break;
		case "cssselector":
		case "css":
			byId = By.cssSelector(locatorValue);
			break;
		case "xpath":
			byId = By.xpath(locatorValue);
			break;
		default:
			System.out.println("Unkown locator type: " + locatorType);

		}

		return byId;

	}

}
