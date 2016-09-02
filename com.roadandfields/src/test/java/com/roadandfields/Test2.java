package com.roadandfields;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Test2 {
	
	public void main() throws InterruptedException {
	WebDriver driver = BrowserFactory.openBrowser("firefox", "https://www.rodanandfields.com/ca/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	//Click All Product link
	CA CAPage= new CA(driver);
	CAPage.becomeAConsultantClick();
	
	String windowHandle1 = driver.getWindowHandle();
	driver.switchTo().window(windowHandle1);
	//switch to window
    //ArrayList<String> window1 = new ArrayList<String> (driver.getWindowHandles());
	//driver.switchTo().window(window1.get(1));
	
	Thread.sleep(3000);
	String policyURL = driver.getCurrentUrl();
	Assert.assertEquals(policyURL, "https://www.rodanandfields.com/_ui/responsive/common/pdf/Archives/Policies_Procedures_CANADA.pdf");

	
	
	
	
	
	}
}
