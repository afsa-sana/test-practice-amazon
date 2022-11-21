package org.amazon.utils;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonUtils {

	public static WebDriver driver;

	public static WebDriver launchChromeBrowser(String applicationUrl) {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\91730\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(applicationUrl);
			driver.manage().window().maximize();
			System.out.println("Browser Launched Successfully");
		} catch (Exception e) {
			System.out.println("Browser Not Launched Successfully");
			e.printStackTrace();
		}
		return driver;
	}

	public static void clickTheElement(WebElement elementToClick, String[]... elementDescription) {
		try {
			elementToClick.click();
			System.out.println("Given element Is Clicked ");
		} catch (Exception e) {
			System.out.println("Given element Is Not Clicked ");
			e.printStackTrace();
		}
	}

	public static void typeValue(WebElement elementToEnterValue, String ValueToEnter, String[]... elementDescription) {
		try {
			elementToEnterValue.sendKeys(ValueToEnter);
			System.out.println("Given Text Entered Successfully In " + elementDescription);
		} catch (Exception e) {
			System.out.println("Given Text Not Entered In " + elementDescription);
			e.printStackTrace();
		}

	}

	public static void verifyElementDisplayed(WebElement elementToDisplay) {

		try {
			boolean elementDisplayed = elementToDisplay.isDisplayed();

			if (elementDisplayed == true) {
				Assert.assertTrue(elementDisplayed);
				System.out.println("Element is Displayed successfully");
			} else {
				System.out.println("Element not Displayed");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			System.out.println("Unable to verify the element");
			e.printStackTrace();
		}

	}

	public static void verifySizeOfListElement(List<WebElement> listOfElement, int ExpectedSize) {
		int listSize = listOfElement.size();
		if (ExpectedSize == listSize) {
			System.out.println("Expected size '" + listSize + "' of the list is matched");
			Assert.assertTrue(true);

		} else {
			System.out.println("Expected size '" + listSize + "' of the list is not matched");
			Assert.assertTrue(false);

		}

	}

}
