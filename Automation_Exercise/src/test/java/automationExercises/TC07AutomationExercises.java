package automationExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC07AutomationExercises {
	// Test Case 7: Verify Test Cases Page
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
	public void test1() {
		// 3. Verify that home page is visible successfully
		WebElement homePage = driver.findElement(By.xpath("//body"));
		Assert.assertTrue(homePage.isDisplayed());

		// 4. Click on 'Test Cases' button
		driver.findElement(By.xpath("//a[contains(text(),'Test Cases')]")).click();

		// 5. Verify user is navigated to test cases page successfully
		WebElement testCasePage = driver.findElement(By.xpath("/html/body"));
		Assert.assertTrue(testCasePage.isDisplayed());
	}

}
