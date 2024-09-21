package qa.tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.ElementFetch;

public class Testsase1 extends BaseTest{
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();	
	
	@Test
	public void sampleMethodForEnteringCredentials() {
		logger.info(browserName+"- Signin into LoginPage");
		homePage.signInButton();
		logger.info(browserName+"- Verifying if Login text is present or not");
		loginPage.verifyIfLoginPageIsLoaded();
		logger.info(browserName+"- Enter Credentials");
		loginPage.enterCredentials();
  }
}
