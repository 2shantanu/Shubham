package com.roadandfields.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.roadandfields.pages.CAPage;
import com.roadandfields.util.BrowserFactory;

@Test
public class Test1 {

	public void main() throws InterruptedException {
	
		WebDriver driver = BrowserFactory.openBrowser("firefox", "https://www.rodanandfields.com/ca/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Click All Product link
		CAPage CAPage= new CAPage(driver);
		CAPage.allProductsClick();
		
		//System.out.println(quickPageURL);
		Thread.sleep(3000);
		String quickPageURL = driver.getCurrentUrl();
		Assert.assertEquals(quickPageURL, "https://www.rodanandfields.com/ca/quick-shop/quickShop");
		
		CAPage.productsDropDown();
		CAPage.priceDropDown();
		
		String RedefineText = driver.findElement(By.xpath(".//*[@id='quick-filtered']/ul[2]/li[1]/form/label")).getText();
		String ReverseText = driver.findElement(By.xpath(".//*[@id='quick-filtered']/ul[2]/li[2]/form/label")).getText();

		Assert.assertEquals(RedefineText, "REDEFINE");
		Assert.assertEquals(ReverseText, "REVERSE");

		String ProductPrice = driver.findElement(By.xpath(".//*[@id='main-content']/div[5]/div[1]/p/span")).getText();
		System.out.println(ProductPrice);
		
		for(int i=0; i<ProductPrice.length(); i++)
		    if( ProductPrice.charAt(i) > 47 && ProductPrice.charAt(i) < 58)
		        System.out.print(ProductPrice.charAt(i));
		
	}
	
}
