package pageEvents;

import org.testng.Assert;

import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {
	ElementFetch ele = new ElementFetch();
	public void verifyIfLoginPageIsLoaded() {
		Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.LoginText).size()>0, "Element not found");
	}
	public void enterCredentials() {
		ele.getWebElement("XPATH", LoginPageElements.emailAddress).sendKeys("rmishra@gmaill.com");
		ele.getWebElement("XPATH", LoginPageElements.passwordField).sendKeys("12345");
	}
}
