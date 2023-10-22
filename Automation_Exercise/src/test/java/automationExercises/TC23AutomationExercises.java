package automationExercises;

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

public class TC23AutomationExercises {
	// Test Case 23: Verify address details in checkout page
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
    public void test1() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        
        //3. Verify that categories are visible on left side bar
        WebElement verifyCategories = driver.findElement(By.xpath("//h2[normalize-space()='Category']"));
        Assert.assertTrue(verifyCategories.isDisplayed());
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        
        //5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("x");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("xasd@mail.com");
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        WebElement gender = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        gender.click();
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
        firstName.sendKeys("evren");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='last_name']"));
        lastName.sendKeys("evren");
        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("cosmos");
        WebElement address1 = driver.findElement(By.xpath("//input[@id='address1']"));
        address1.sendKeys("dosemealti , 132 ");
        WebElement address2 = driver.findElement(By.xpath("//input[@id='address2']"));
        address2.sendKeys(" 3/1");
        WebElement country = driver.findElement(By.xpath("//select[@id='country']"));
        country.click();
        country.sendKeys("can");
        WebElement state= driver.findElement(By.xpath("//input[@id='state']"));
        state.sendKeys("onta");
        WebElement city=driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("ontanario");
        WebElement zipcode =driver.findElement(By.xpath("//input[@id='zipcode']"));
        zipcode.sendKeys("2054 Ont");
        WebElement phone =driver.findElement(By.xpath("//input[@id='mobile_number']"));
        phone.sendKeys("+1 500 50 50505");
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
        WebElement accCreate = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
        Assert.assertTrue(accCreate.isDisplayed());
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement acCreate = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
        Assert.assertTrue(acCreate.isDisplayed());
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        
        //7. Verify ' Logged in as username' at top
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']/child::li[10]")));
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[10]"));
        Assert.assertTrue(loggedInAsUsername.isDisplayed());
        
        //8. Add products to cart
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']")));
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        Thread.sleep(2000);
        
        //9. Click 'Cart' button
        driver.findElement(By.xpath("//a[text()=' Cart']")).click();
        
        //10. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(cartPage.isDisplayed());
        
        //11. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        
        //12. Verify that the delivery address is same address filled at the time registration of account
        WebElement delivery = driver.findElement(By.xpath("//h2[normalize-space()='Address Details']"));
        System.out.println(delivery);
        
        //13. Verify that the billing address is same address filled at the time registration of account
        WebElement billing = driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']"));
        System.out.println(billing);
        
        //14. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
        
        //15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String Delete = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
		System.out.println(Delete);
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
    }
}
