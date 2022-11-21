package org.amazon.testscripts;

import java.util.List;

import org.amazon.pages.HomePage;
import org.amazon.pages.ResultPage;
import org.amazon.utils.AmazonUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonLoginTestScripts extends AmazonUtils {

	public static String URL = "https://www.amazon.in/ref=nav_logo";

	//Please follow the same template
	/**
	 * @author afsana
	 * @throws InterruptedException
	 */
	@Test
	public void tc001() throws InterruptedException {
		
		WebDriver driver = launchChromeBrowser(URL);
		HomePage homepageElement = new HomePage(driver);
		typeValue(homepageElement.getSearchBox(), "iphone");
		clickTheElement(homepageElement.getSearchButton());
		ResultPage resultPageElements = new ResultPage(driver);
		verifyElementDisplayed(resultPageElements.getIphoneFromResultPage());
		List<WebElement> allIphonesElement = resultPageElements.getAllIphonesElement();
		verifySizeOfListElement(allIphonesElement, 17);
		//Or
//		verifySizeOfListElement(resultPageElements.getAllIphonesElement(), 18);
		List<WebElement> customerReview = resultPageElements.getCustomerReview();
		System.out.println("Size of elements ::"+customerReview.size());
		System.out.println("@FindBys::"+customerReview.get(0).isDisplayed());
		driver.navigate().back();
		driver.quit();
	}

}
