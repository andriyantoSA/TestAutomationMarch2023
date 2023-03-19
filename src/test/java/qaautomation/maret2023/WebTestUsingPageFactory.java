package qaautomation.maret2023;

import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.maret2023.pages.LoginPageFactory;
import qaautomation.maret2023.pages.ProfilePageFactory;

public class WebTestUsingPageFactory extends BasedWebTestUsingThreadLocalParalel{
//	LoginPageFactory loginPageFactory = new LoginPageFactory(driver,explicitWait);
//	ProfilePageFactory profilePageFactory = new ProfilePageFactory(driver, explicitWait);
	
	@Test
	public void testLogin() {
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver,explicitWait);
		ProfilePageFactory profilePageFactory = new ProfilePageFactory(driver, explicitWait);
		//loginpage
		loginPageFactory.inputUsername("tomsmith");
		loginPageFactory.inputPassword("SuperSecretPassword!");
		loginPageFactory.clickloginBtn();
		
		//profilepage
		String actualText = profilePageFactory.getProfileText();
		String expectedText = "You logged into a secure area!";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testWrongUsername() {
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver,explicitWait);
		ProfilePageFactory profilePageFactory = new ProfilePageFactory(driver, explicitWait);
		//loginpage
		loginPageFactory.inputUsername("ngasal");
		loginPageFactory.inputPassword("SuperSecretPassword!");
		loginPageFactory.clickloginBtn();
		
		//profilepage
		String actualText = profilePageFactory.getProfileText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testWrongPassword() {
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver,explicitWait);
		ProfilePageFactory profilePageFactory = new ProfilePageFactory(driver, explicitWait);
		//loginpage
		loginPageFactory.inputUsername("tomsmith");
		loginPageFactory.inputPassword("salah!");
		loginPageFactory.clickloginBtn();
		
		//profilepage
		String actualText = profilePageFactory.getProfileText();
		//String actualText = driver.get().findElement(By.id("flash")).getText();
		String expectedText = "Your password is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
}
