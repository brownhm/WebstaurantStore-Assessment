Documentation
This project contains utilities and test steps for the WebstaurantStore website using Selenium WebDriver, Cucumber, and TestNG.

Package: com.webstaurant.utils

Class: ReadConfig (extends Constants)
Singleton class that reads the configuration settings.
Methods:
private ReadConfig(): Default constructor.
private ReadConfig(String filepath): Constructor that takes a file path and initializes an ObjectMap.
public static ReadConfig getInstance(): Returns an instance of ReadConfig. Creates one if it doesn't exist.

Class: ObjectMap
Class for managing object locators for web elements.
Methods:
public ObjectMap(String path): Constructor that takes a file path and initializes a Properties object.
public By getLocator(String strElement): Takes a string and returns a locator (By object) based on the properties file.

Class: Constants
Class that holds global constants.
Fields:
public static String browser: The browser to use for testing.
public static String pathOR: The path to the properties file containing the locators for web elements.
public static ObjectMap objMap: An instance of ObjectMap.
public static String applicationURL: The WebstaurantStore website URL.

Class: CommonUI (extends Constants)
Utility class for handling common UI interactions.

Methods:
public static void openBrowser(String browser): Opens the specified browser.
public static void getChromeDetails(): Initializes the Chrome WebDriver.
public static void getEdgeDetails(): Initializes the Edge WebDriver.
public static void getFirefoxDetails(): Initializes the Firefox WebDriver.
public static void navigate(String url): Navigates to the specified URL.
public static void quitBrowser(): Quits the browser.
public static boolean isDisplayed(String objectName): Checks if a web element is displayed.
public static void click(String objectName): Clicks a web element.
public static void enter(String objectName, String value): Enters a value in a web element.
public static void explicitWait(String objectName): Waits for a web element to become visible.
public static void verifyListText(String objectName, String expectedValue): Verifies that the text of a list of web elements contains the expected value.
public static void clickLastWebElement(String objectName): Clicks the last web element in a list.
public static void verifyText(String objectName, String expectedValue): Verifies that the text of a web element contains the expected value.


Package: com.webstaurant.steps
Class: TestSteps (extends ReadConfig)
Class containing Cucumber step definitions for testing the WebstaurantStore website.
Methods:
public TestSteps(): Constructor that initializes an instance of ReadConfig.
@Before public void setUp(): Sets up the test environment by opening the browser.
@Given public void user_navigates_to_the_webstaurant_store_website(): Navigates to the WebstaurantStore website.
@When public void enterText(DataTable dataTable): Enters text into web elements.
@When public void clickObject(DataTable dataTable): Clicks web elements.
@When public void verifyWebListText(DataTable dataTable): Verifies the text of a list of web elements.
@When public void addLastItemToTheCart(DataTable dataTable): Adds the last item to the cart.
@Then public void verifyText(DataTable dataTable): Verifies the text of a web element.
@After public void tearDown(): Tears down the test environment by closing the browser.