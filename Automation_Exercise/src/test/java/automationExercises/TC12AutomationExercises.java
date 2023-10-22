package automationExercises;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
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

public class TC12AutomationExercises {
	// Test Case 12: Add Products in Cart
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
	public void test1() throws AWTException, InterruptedException {
		// 3. Verify that home page is visible successfully
		WebElement homePage = driver.findElement(By.xpath("//body"));
		Assert.assertTrue(homePage.isDisplayed());

		// 4. Click 'Products' button
		driver.findElement(By.xpath("//a[@href='/products']")).click();

		// 5. Hover over first product and click 'Add to cart'
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']")))
				.moveToElement(driver.findElement(By.xpath("//a[@data-product-id='1']"))).click().build().perform();
		Thread.sleep(2000);

		// 6. Click 'Continue Shopping' button
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-success close-modal btn-block']")));
		driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

		// 7. Hover over second product and click 'Add to cart'
		act.moveToElement(driver.findElement(By.xpath("//div[@class='productinfo text-center']")))
				.moveToElement(driver.findElement(By.xpath("//a[@data-product-id='2']"))).click().build().perform();
		Thread.sleep(2000);

		// 8. Click 'View Cart' button
		driver.findElement(By.xpath("//u[text()='View Cart']")).click();

		// 9. Verify both products are added to Cart
		WebElement product1 = driver.findElement(By.xpath("(//td[@class='cart_description'])[1]"));
		Assert.assertTrue(product1.isDisplayed());
		WebElement product2 = driver.findElement(By.xpath("(//td[@class='cart_description'])[2]"));
		Assert.assertTrue(product2.isDisplayed());

		// 10. Verify their prices, quantity and total price
		WebElement price1 = driver.findElement(By.xpath("(//*[@class='cart_price'])[1]"));
		Assert.assertTrue(price1.isDisplayed());
		WebElement price2 = driver.findElement(By.xpath("(//*[@class='cart_price'])[2]"));
		Assert.assertTrue(price2.isDisplayed());
		WebElement quantity1 = driver.findElement(By.xpath("(//*[@class='disabled'])[1]"));
		Assert.assertTrue(quantity1.isDisplayed());
		WebElement quantity2 = driver.findElement(By.xpath("(//*[@class='disabled'])[2]"));
		Assert.assertTrue(quantity2.isDisplayed());
		WebElement total1 = driver.findElement(By.xpath("(//*[@class='cart_total_price'])[1]"));
		Assert.assertTrue(total1.isDisplayed());
		WebElement total2 = driver.findElement(By.xpath("(//*[@class='cart_total_price'])[2]"));
		Assert.assertTrue(total2.isDisplayed());

	}
}
