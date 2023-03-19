package qaautomation.maret2023;

import org.testng.annotations.Test;

import qaautomation.maret2023.pages.CommonPage;

public class CommonTest extends BasedWebTestUsingThreadLocalParalel{
	CommonPage commonPage = new CommonPage(driver, explicitWait);
	
	@Test
	public void testSwitching() {
		commonPage.openUrl("https://facebook.com");
		commonPage.openNewTab();
		commonPage.switchWindow(1);
		commonPage.openUrl("https://twitter.com");
		commonPage.openNewWindow();
		commonPage.openUrl("https://instagram.com");
	}
}
