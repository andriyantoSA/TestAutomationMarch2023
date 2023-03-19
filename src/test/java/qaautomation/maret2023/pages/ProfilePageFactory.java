package qaautomation.maret2023.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePageFactory extends BasePageFactory{
	public ProfilePageFactory (ThreadLocal<WebDriver> driver,ThreadLocal<WebDriverWait> explicitWait) {
		super(driver,explicitWait);
		PageFactory.initElements(driver.get(), this);
	}
	
	@FindBy(id = "flash")
	private WebElement profileText;
	
	
	public String getProfileText() {
		return profileText.getText();
	}
}
