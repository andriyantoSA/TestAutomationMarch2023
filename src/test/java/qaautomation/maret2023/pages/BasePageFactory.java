package qaautomation.maret2023.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	public BasePageFactory(ThreadLocal<WebDriver> driver,ThreadLocal<WebDriverWait> explicitWait) {
		this.driver = driver;
		this.explicitWait = explicitWait;
	}
	
//	public void clickAndWait(By locator) {
//		explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(locator));
//		driver.get().findElement(locator).click();
//	}
//	
//	public void setText(By locator, String text) {
//		driver.get().findElement(locator).sendKeys(text);
//	}
//	
//	public String getText(By locator) {
//		return driver.get().findElement(locator).getText();
//	}
}
