package qaautomation.maret2023.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
	By username = By.id("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//*[@name='login']/child::button");
	
	public LoginPage(ThreadLocal<WebDriver> driver,ThreadLocal<WebDriverWait> explicitWait) {
		super(driver,explicitWait);
	}
	
	public void inputUsername(String usernameInput) {
		setText(username,usernameInput);
	}
	
	public void inputPassword(String passwordInput) {
		setText(password,passwordInput);
	}
	
	public void clickloginBtn() {
		clickAndWait(loginBtn);
	}
}
