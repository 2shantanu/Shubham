package com.roadandfields.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SelectSponsorPage {

	private WebDriver driver;
	
	@FindBy(how=How.PARTIAL_LINK_TEXT, using="Rodan + Fields Policies and Procedures")
	private WebElement policyAndProc;

	@FindBy(how=How.ID, using="sponserparam")
	private WebElement searchBox;
	
	@FindBy(how=How.ID, using="search-sponsor-button")
	private WebElement searchButton;
	

	  //Constructor
	  public SelectSponsorPage(WebDriver driver){
	       this.driver=driver;
	       //Initialize Elements
	       PageFactory.initElements(driver, this);
	   }
	

	public void SearchClick() throws InterruptedException{

		policyAndProc.click();
		Thread.sleep(3000);
		ArrayList<String> window1 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(window1.get(1));

		String url1 = driver.getCurrentUrl();
		String url2 = "https://www.rodanandfields.com/_ui/responsive/common/pdf/Archives/Policies_Procedures_CANADA.pdf";
		boolean chk = url2.toLowerCase().contains(url1.toLowerCase());
		System.out.println(url1);
		Assert.assertTrue(chk);

		driver.switchTo().window(window1.get(0));
		searchBox.click();		
		searchBox.sendKeys("product");
		searchButton.click();
	}
}
