package qaautomation.maret2023.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{
	public ProfilePage (ThreadLocal<WebDriver> driver,ThreadLocal<WebDriverWait> explicitWait) {
		super(driver,explicitWait);
	}
	
	By profileText = By.id("flash");
	
	public String getProfileText() {
		return getText(profileText);
	}
}
