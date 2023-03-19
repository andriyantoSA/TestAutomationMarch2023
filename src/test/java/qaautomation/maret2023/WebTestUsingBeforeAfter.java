package qaautomation.maret2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTestUsingBeforeAfter {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
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
