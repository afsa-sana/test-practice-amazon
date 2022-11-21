package org.amazon.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {

	public ResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@data-index='2']")
	private WebElement iphoneFromResultPage;

	@FindBy(xpath = "//span[contains(text(),\"Apple iPhone\")]")
	private List<WebElement> allIphonesElement;

//	@FindBys({ @FindBy(xpath = "//li[contains(@id,'p_72/1318')]"),
//			@FindBy(xpath = "//li[@id='p_72/1318476031']") })
//	private List<WebElement> customerReview;

	
	@FindAll({ @FindBy(xpath = "//li[contains(@id,'p_72/1318')]"), 
		@FindBy(xpath = "//li[@id='p_72/1318476031']") })
	private List<WebElement> customerReview;

	public List<WebElement> getCustomerReview() {
		return customerReview;
	}

	public WebElement getIphoneFromResultPage() {
		return iphoneFromResultPage;
	}

	public List<WebElement> getAllIphonesElement() {
		return allIphonesElement;
	}

}
