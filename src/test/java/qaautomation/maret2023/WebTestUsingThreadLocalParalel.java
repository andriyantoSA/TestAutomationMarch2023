package qaautomation.maret2023;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTestUsingThreadLocalParalel extends BasedWebTestUsingThreadLocalParalel{

	@Test
	public void testLogin() {
		explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		//loginpage
		driver.get().findElement(By.id("username")).sendKeys("tomsmith");
		driver.get().findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.get().findElement(By.xpath("//*[@name='login']/child::button")).click();
		//driver.get().findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		//profilepage
		String actualText = driver.get().findElement(By.id("flash")).getText();
		String expectedText = "You logged into a secure area!";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testWrongUsername() {
		driver.get().findElement(By.id("username")).sendKeys("ngasal");
		driver.get().findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.get().findElement(By.xpath("//*[@name='login']/child::button")).click();
		//driver.get().findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String actualText = driver.get().findElement(By.id("flash")).getText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testWrongPassword() {
		driver.get().findElement(By.id("username")).sendKeys("tomsmith");
		driver.get().findElement(By.name("password")).sendKeys("salah!");
		driver.get().findElement(By.xpath("//*[@name='login']/child::button")).click();
		//driver.get().findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String actualText = driver.get().findElement(By.id("flash")).getText();
		String expectedText = "Your password is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
}
