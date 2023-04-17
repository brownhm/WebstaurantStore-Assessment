package com.webstaurant.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonUI extends Constants {

	public static WebDriver driver;

	public static void openBrowser(String browser) {
		try {

			switch (browser.toLowerCase()) {

			case "chrome":
				getChromeDetails();
				break;
			case "firefox":
				getFirefoxDetails();
				break;
			case "edge":
				getEdgeDetails();
				break;
			}

		} catch (Exception e) {
			System.out.println("Browser has [" + browser + "] value. Make sure to pass [chrome/ie/firefox]");
			e.printStackTrace();

		}
	}

	public static void getChromeDetails() {

		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions chOptions = new ChromeOptions();
		chOptions.addArguments("--test-type");
		chOptions.addArguments("--start-maximized");
		chOptions.setAcceptInsecureCerts(true);
		chOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		chOptions.addArguments("--disable-browser-side-navigation");
		chOptions.addArguments("--disable-web-security");
		driver = new ChromeDriver(chOptions);

	}

	public static void getEdgeDetails() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		driver = new EdgeDriver(edgeOptions);

	}

	public static void getFirefoxDetails() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		driver = new FirefoxDriver(firefoxOptions);

	}

	public static void navigate(String url) {

		try {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Check the url [" + url + "], make sure it contains correct format");
			e.printStackTrace();
		}

	}

	public static void quitBrowser() {

		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Driver object is null");
			e.printStackTrace();
		}
	}

	public static boolean isDisplayed(String objectName) {
		WebElement element = driver.findElement(objMap.getLocator(objectName));
		try {

			return element.isDisplayed();

		} catch (Exception e) {

			System.out.println("Element is not displayed:" + element);
			e.printStackTrace();

			return false;
		}
	}

	public static void click(String objectName) {
		WebElement element = driver.findElement(objMap.getLocator(objectName));
		if (isDisplayed(objectName)) {
			element.click();
		}
	}

	public static void enter(String objectName, String value) {

		WebElement element = driver.findElement(objMap.getLocator(objectName));
		if (isDisplayed(objectName)) {
			element.clear();
			element.sendKeys(value);
		}

	}

	public static void explicitWait(String objectName) {
		WebElement element = driver.findElement(objMap.getLocator(objectName));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void verifyListText(String objectName, String expectedValue) {
		List<WebElement> elements = driver.findElements(objMap.getLocator(objectName));
		for (WebElement element : elements) {
			Assert.assertTrue(element.getText().contains(expectedValue),
					"Actual value does not contain '" + expectedValue + "': " + element.getText());
		}

	}

	public static void clickLastWebElement(String objectName) {
		List<WebElement> elements = driver.findElements(objMap.getLocator(objectName));
		WebElement lastItem = elements.get(elements.size() - 1);
		lastItem.click();
	}

	public static void verifyText(String objectName, String expectedValue) {
		WebElement element = driver.findElement(objMap.getLocator(objectName));
		String text = null;
		if (isDisplayed(objectName)) {
			text = element.getText();
			Assert.assertTrue(text.contains(expectedValue),
					"Actual value does not contain '" + expectedValue + "': " + element.getText());
		}

	}

}
