package automationExercises;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC17AutomationExercises {
	// Test Case 17: Remove Products From Cart
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com");
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}

	@Test
	public void test1() throws InterruptedException {
		// 2. Navigate to url 'http://automationexercise.com'
		driver.get("http://automationexercise.com");
		
		// 3. Verify that home page is visible successfully
		WebElement homePage = driver.findElement(By.xpath("//body"));
		Assert.assertTrue(homePage.isDisplayed());
		
		// 4. Add products to cart
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']")));
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
		
		// 5. Click 'Cart' button
		driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();
		
		// 6. Verify that cart page is displayed
		WebElement cartPage = driver.findElement(By.xpath("//li[@class='active']"));
		Assert.assertTrue(cartPage.isDisplayed());
		
		// 7. Click 'X' button corresponding to particular product
		driver.findElement(By.xpath("//i[@class='fa fa-times']")).click();
		Thread.sleep(2000);
		
		// 8. Verify that product is removed from the cart
		WebElement verifyRemove = driver.findElement(By.xpath("//b[normalize-space()='Cart is empty!']"));
		Assert.assertTrue(verifyRemove.isDisplayed());
	}
}
