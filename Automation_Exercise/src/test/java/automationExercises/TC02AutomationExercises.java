package automationExercises;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC02AutomationExercises {
	// Test Case 2: Login User with correct email and password
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterTest
	public void finish() {
		driver.close();
	}

	@Test

	public void test1() {
		// 2. Navigate to url 'http://automationexercise.com'
		driver.get("http://automationexercise.com");

		// 3. Verify that home page is visible successfully
		WebElement homePage = driver.findElement(By.xpath("//html[@lang='en']"));
		if (homePage.isDisplayed()) {
			System.out.println("HomePage testing PASSED");
		} else {
			System.out.println("HomePage testing FAILED");
		}

		// 4. Click on 'Signup / Login' button
		driver.findElement(By.xpath("//a[@href='/login']")).click();

		// 5. Verify 'Login to your account' is visible
		WebElement loginToYourAcc = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
		if (loginToYourAcc.isDisplayed()) {
			System.out.println("Testing PASSED");
		} else {
			System.out.println("Testing FAILED");
		}

		// 6. Enter correct email address and password
		WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		email.sendKeys("test16@mail.com");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("Password");

		// 7. Click 'login' button
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		// 8. Verify that 'Logged in as username' is visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']/child::li[10]")));
		WebElement loggedInAsUsername = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[10]"));
		if (loggedInAsUsername.isDisplayed()) {
			System.out.println("Testing PASSED");
		} else {
			System.out.println("Testing FAILED");
		}
		// 9. Click 'Delete Account' button
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[5]")).click();

		// 10. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Account Deleted!']")));
		String Delete = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
		System.out.println(Delete);
		driver.findElement(By.xpath("//a[text()='Continue']")).click();


	}
}
