package qaautomation.maret2023;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebTestUsingBasedWebTest extends BasedWebTest{
	
	@Test
	public void testLogin() {
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@name='login']/child::button")).click();
		//driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String actualText = driver.findElement(By.id("flash")).getText();
		String expectedText = "You logged into a secure area!";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testWrongUsername() {
		driver.findElement(By.id("username")).sendKeys("ngasal");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@name='login']/child::button")).click();
		//driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String actualText = driver.findElement(By.id("flash")).getText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	@Test
	public void testWrongPassword() {
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("salah!");
		driver.findElement(By.xpath("//*[@name='login']/child::button")).click();
		//driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String actualText = driver.findElement(By.id("flash")).getText();
		String expectedText = "Your password is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
	}
}
