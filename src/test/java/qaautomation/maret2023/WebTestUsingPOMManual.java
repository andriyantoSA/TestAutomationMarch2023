package qaautomation.maret2023;

import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.maret2023.pages.LoginPage;
import qaautomation.maret2023.pages.ProfilePage;

public class WebTestUsingPOMManual extends BasedWebTestUsingThreadLocalParalel{
	LoginPage loginPage = new LoginPage(driver,explicitWait);
	ProfilePage profilePage = new ProfilePage(driver, explicitWait);
	
	@Test
	public void testLogin() {
		//loginpage
		loginPage.inputUsername("tomsmith");
		loginPage.inputPassword("SuperSecretPassword!");
		loginPage.clickloginBtn();
		
		//profilepage
		String actualText = profilePage.getProfileText();
		String expectedText = "You logged into a secure area!";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testWrongUsername() {
		//loginpage
		loginPage.inputUsername("ngasal");
		loginPage.inputPassword("SuperSecretPassword!");
		loginPage.clickloginBtn();
		
		//profilepage
		String actualText = profilePage.getProfileText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testWrongPassword() {
		//loginpage
		loginPage.inputUsername("tomsmith");
		loginPage.inputPassword("salah!");
		loginPage.clickloginBtn();
		
		//profilepage
		String actualText = profilePage.getProfileText();
		//String actualText = driver.get().findElement(By.id("flash")).getText();
		String expectedText = "Your password is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
}
