package automationExercises;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC13AutomationExercises {
	// Test Case 13: Verify Product quantity in Cart
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
		// driver.close();
	}

	@Test
	public void test1() throws AWTException, InterruptedException {
		// 3. Verify that home page is visible successfully
		WebElement homePage = driver.findElement(By.xpath("//body"));
		Assert.assertTrue(homePage.isDisplayed());

		// 4. Click 'View Product' for any product on home page
		driver.findElement(By.xpath("//div[@class='features_items']/child::div[4]/child::div[1]/child::div[2]"))
				.click();

		// 5. Verify product detail is opened
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Sleeveless Dress']")));
		String Dress = driver.findElement(By.xpath("//h2[text()='Sleeveless Dress']")).getText();
		System.out.println(Dress);

		// 6. Increase quantity to 4
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("4");

		// 7. Click 'Add to cart' button
		driver.findElement(By.xpath("//button[@type='button']")).click();

		// 8. Click 'View Cart' button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//u[text()='View Cart']")));
		driver.findElement(By.xpath("//u[text()='View Cart']")).click();
		Thread.sleep(2000);

		// 9. Verify that product is displayed in cart page with exact quantity
		String tableData = driver.findElement(By.xpath("//table[@id='cart_info_table']/child::tbody")).getText();
		System.out.print(tableData);
		Thread.sleep(2000);
	}
}
