package qaautomation.maret2023;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTest {
	
	@Test
	public void testLogin() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		driver.get("https://the-internet.herokuapp.com/login");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@name='login']/child::button")).click();
		//driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String actualText = driver.findElement(By.id("flash")).getText();
		String expectedText = "You logged into a secure area!";
		Assert.assertEquals(actualText, expectedText);
		driver.quit();
	}
	
	@Test
	public void testWrongUsername() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("ngasal");
		driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@name='login']/child::button")).click();
		//driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String actualText = driver.findElement(By.id("flash")).getText();
		String expectedText = "Your username is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
		driver.quit();
	}
	
	@Test
	public void testWrongPassword() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.name("password")).sendKeys("salah!");
		driver.findElement(By.xpath("//*[@name='login']/child::button")).click();
		//driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String actualText = driver.findElement(By.id("flash")).getText();
		String expectedText = "Your password is invalid";
		Assert.assertTrue(actualText.contains(expectedText));
		driver.quit();
	}
}
