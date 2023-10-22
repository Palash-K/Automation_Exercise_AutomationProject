package automationExercises;

import java.awt.AWTException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

public class TC24AutomationExercises {
	// Test Case 24: Download Invoice after purchase order
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
    public void test1() throws AWTException, IOException, InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        
        //3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath(" //section[@id='slider']//div[@class='item active']//div[1]"));
        Assert.assertTrue(home.isDisplayed());
        
        //4. Add products to cart
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']")));
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        Thread.sleep(2000);
        
        //5. Click 'Cart' button
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        
        //6. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(cartPage.isDisplayed());
        
        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        
        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();
        
        //9. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("xmail");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("xmail@mail.com");
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).clear();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("name");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        WebElement daySlct = driver.findElement(By.xpath("//select[@id='days']"));
        daySlct.click();
        daySlct.sendKeys("23");
        daySlct.click();
        WebElement monthSlct = driver.findElement(By.xpath("//select[@id='months']"));
        monthSlct.click();
        monthSlct.sendKeys("N");
        monthSlct.click();
        WebElement yearSlct = driver.findElement(By.xpath("//select[@id='years']"));
        yearSlct.click();
        yearSlct.sendKeys("1980");
        yearSlct.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='first_name']"));
        firstName.sendKeys("szgn");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastName.sendKeys("szgn");
        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("ictpera");
        WebElement address1 = driver.findElement(By.xpath("//input[@id='address1']"));
        address1.sendKeys("Umit , 2526 ");
        WebElement address2 = driver.findElement(By.xpath("//input[@id='address2']"));
        address2.sendKeys(" 4/1");
        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        country.click();
        country.sendKeys("can");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("onta");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("ontanario");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("2054 Ont");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("+1 500 50 50505");
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
        
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accCreate = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
        Assert.assertTrue(accCreate.isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        
        //11. Verify ' Logged in as username' at top
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']/child::li[10]")));
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[10]"));
        Assert.assertTrue(loggedInAsUsername.isDisplayed());
        
        //12.Click 'Cart' button
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        
        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        
        //14. Verify Address Details and Review Your Order
        WebElement adress = driver.findElement(By.xpath("//h2[normalize-space()='Address Details']"));
        Assert.assertTrue(adress.isDisplayed());
        WebElement review = driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']"));
        Assert.assertTrue(review.isDisplayed());
        
        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("test test test");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("szgnmm");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("1234123412341324");
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("11");
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("25");
        
        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        
        //18. Verify success message 'Your order has been placed successfully!'
        WebElement success = driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(success.isDisplayed());
        
        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        driver.findElement(By.xpath(" //a[@class='btn btn-default check_out']")).click();
        Thread.sleep(2000);
        Path filePath = Path.of("C:\\Users\\HP\\Downloads\\invoice.txt");
        String invoice = Files.readString(Path.of(filePath.toString()));
        System.out.println(invoice);

        //20. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        
        //21. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
        
        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String Delete = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
		System.out.println(Delete);
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
    }
}
