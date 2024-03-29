package automationExercises;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01AutomationExercises {

	public static void main(String[] args) {
		// Test Case 1: Register User
		System.setProperty("webdriver.chrome.driver", "E:\\XLR\\Selenium JARs\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 2. Navigate to url 'http://automationexercise.com'
		driver.get("http://automationexercise.com");

		// 3. Verify that home page is visible successfully
		WebElement homePage = driver.findElement(By.cssSelector("html"));
		if (homePage.isDisplayed()) {
			System.out.println("Home page testing PASSED");
		} else
			System.out.println("Home page testing FAILED");

		// 4. Click on 'Signup / Login' button
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[4]")).click();

		// 5. Verify 'New User Signup!' is visible
		WebElement newUserSignup = driver.findElement(By.cssSelector("div[class='signup-form'] h2"));
		if (newUserSignup.isDisplayed()) {
			System.out.println("New user signup testing PASSED");
		} else
			System.out.println("New user signup testing FAILED");

		// 6. Enter name and email address
		WebElement name = driver.findElement(By.xpath("//*[@name='name']"));
		name.sendKeys("username");
		WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		email.sendKeys("testones@mail.com");

		// 7. Click 'Signup' button
		driver.findElement(By.xpath("//button[text()='Signup']")).click();

		// 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
		WebElement enterAccountInformation = driver
				.findElement(By.cssSelector("#form > div > div > div > div > h2 > b"));
		if (enterAccountInformation.isDisplayed()) {
			System.out.println("ENTER ACCOUNT INFORMATION testing PASSED");
		} else {
			System.out.println("ENTER ACCOUNT INFORMATION testing FAILED");
		}

		// 9. Fill details: Title, Name, Email, Password, Date of birth
		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		WebElement userName = driver.findElement(By.xpath("//input[@id='name']"));
		userName.clear();
		userName.sendKeys("name");
		WebElement userPassword = driver.findElement(By.xpath("//input[@id='password']"));
		userPassword.sendKeys("passwords");
		WebElement date = driver.findElement(By.xpath("//*[@id=\"days\"]"));
		date.click();
		date.sendKeys("3");
		WebElement month = driver.findElement(By.xpath("//*[@id=\"months\"]"));
		month.click();
		month.sendKeys("may");
		WebElement year = driver.findElement(By.xpath("//*[@id=\"years\"]"));
		year.click();
		year.sendKeys("1980");

		// 10. Select checkbox 'Sign up for our newsletter!'
		driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();

		// 11. Select checkbox 'Receive special offers from our partners!'
		driver.findElement(By.xpath("//*[@id=\"optin\"]")).click();

		// 12. Fill details: First name, Last name, Company, Address, Address2, Country,
		// State, City, Zipcode, Mobile Number
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
		firstName.sendKeys("erol");
		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
		lastName.sendKeys("evren");
		WebElement company = driver.findElement(By.xpath("//*[@id=\"company\"]"));
		company.sendKeys("cosmos");
		WebElement adresses = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
		adresses.sendKeys("antalya");
		WebElement adresses2 = driver.findElement(By.xpath("//*[@id=\"address2\"]"));
		adresses2.sendKeys("dosemealti");
		WebElement country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
		country.click();
		country.sendKeys("canada".toLowerCase());
		WebElement state = driver.findElement(By.xpath("//*[@id=\"state\"]"));
		state.sendKeys("usak");
		WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
		city.sendKeys("banaz");
		WebElement zipcode = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
		zipcode.sendKeys("07100");
		WebElement mobileNumber = driver.findElement(By.xpath("//*[@id=\"mobile_number\"]"));
		mobileNumber.sendKeys("123456789");

		// 13. Click 'Create Account button'
		driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();

		// 14. Verify that 'ACCOUNT CREATED!' is visible
		WebElement accountCreate = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
		if (accountCreate.isDisplayed()) {
			System.out.println("ACCOUNT CREATED testing PASSED");
		} else
			System.out.println("ACCOUNT CREATED testing FAILED");

		// 15. Click 'Continue' button
		driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

		// 16. Verify that 'Logged in as username' is visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']/child::li[10]")));
		WebElement loggedInAsUsername = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[10]"));
		if (loggedInAsUsername.isDisplayed()) {
			System.out.println("Logged in as username testing PASSED");
		} else
			System.out.println("Logged in as username testing FAILED");

		// 17. Click 'Delete Account' button
		WebElement deleteAccount = driver.findElement(By.xpath("//a[@href='/delete_account']"));
		deleteAccount.click();

		// 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
		WebElement accountDelete = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));

		if (accountDelete.isDisplayed()) {
			System.out.println("ACCOUNT DELETED! testing PASSED");
		} else
			System.out.println("ACCOUNT DELETED! testing FAILED");
		driver.findElement(By.xpath("//a[text()='Continue']")).click();

		driver.close();
	}
}
