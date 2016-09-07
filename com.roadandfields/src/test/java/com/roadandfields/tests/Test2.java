package com.roadandfields.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.roadandfields.pages.CAPage;
import com.roadandfields.pages.SelectSponsorPage;
import com.roadandfields.util.BrowserFactory;

@Test
public class Test2 {
	
	public void main() throws InterruptedException {
	WebDriver driver = BrowserFactory.openBrowser("firefox", "https://www.rodanandfields.com/ca/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	//Click All Product link
	CAPage CAPage = new CAPage(driver);
	CAPage.becomeAConsultantClick();

	SelectSponsorPage SelectSponsorPage = new SelectSponsorPage(driver);
	SelectSponsorPage.SearchClick();
	
	
	}
}
