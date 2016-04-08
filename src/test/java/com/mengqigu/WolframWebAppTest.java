package com.mengqigu;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class WolframWebAppTest {
	WebDriver driver;

	@BeforeClass
 	public void setUp() {
		driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 	}

	@Test()
	public void testCreateNoteBook() {
		WolframCloudPage cloudPage = new WolframCloudPage(driver);
		Assert.assertEquals(cloudPage.isPageOpened(),true);
		cloudPage.clickWolframDevelopmentPlatformButton();

		SignInPage signIn = new SignInPage(driver);
		Assert.assertEquals(signIn.isPageOpened(),true);
		signIn.signIn("mengqigu@gmail.com", "wolfram123");

		DevelopmentPlatformHome platformHomePage = new DevelopmentPlatformHome(driver);
		Assert.assertEquals(platformHomePage.isPageOpened(),true);
		platformHomePage.selectNbFromDropDown();
		platformHomePage.switchToPopUpNoteBook();

		NoteBookPage noteBook = new NoteBookPage(driver);
		Assert.assertEquals(noteBook.isPageOpened(),true);
		noteBook.clickRename();
		Assert.assertEquals(noteBook.isSuffixNb(),true);
	}

	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}
