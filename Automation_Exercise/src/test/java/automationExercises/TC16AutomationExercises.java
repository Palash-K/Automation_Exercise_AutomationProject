package automationExercises;

import java.awt.AWTException;
import java.awt.Robot;
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

public class TC16AutomationExercises {
	// Test Case 16: Place Order: Login before Checkout
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
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        
        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        
        //5. Fill email, password and click 'Login' button
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).
                sendKeys("testzz@mail.com");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).
                sendKeys("Password");
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
        
        //6. Verify 'Logged in as username' at top
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='nav navbar-nav']/child::li[10]")));
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[10]"));
        Assert.assertTrue(loggedInAsUsername.isDisplayed());
        
        //7. Add products to cart
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue Shopping']")));
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
        Thread.sleep(2000);
        
        //8. Click 'Cart' button
        driver.findElement(By.xpath("//a[normalize-space()='Cart']")).click();
        
        //9. Verify that cart page is displayed
        WebElement cartPage = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(cartPage.isDisplayed());
        
        //10. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        
        //11. Verify Address Details and Review Your Order
        WebElement adress = driver.findElement(By.xpath("//h2[normalize-space()='Address Details']"));
        Assert.assertTrue(adress.isDisplayed());
        WebElement review = driver.findElement(By.xpath("//h2[normalize-space()='Review Your Order']"));
        Assert.assertTrue(review.isDisplayed());
        
        //12. Enter description in comment text area and click 'Place Order'
        Robot rbt = new Robot();
        rbt.mouseWheel(9);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Test");
        driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
        
        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name_on_card")));
        driver.findElement(By.name("name_on_card")).sendKeys("Testing");
		driver.findElement(By.name("card_number")).sendKeys("0123456789");
		driver.findElement(By.name("cvc")).sendKeys("123");
		driver.findElement(By.name("expiry_month")).sendKeys("12");
		driver.findElement(By.name("expiry_year")).sendKeys("2024");
        
        //14. Click 'Pay and Confirm Order' button
		driver.findElement(By.id("submit")).click();
        
        //15. Verify success message 'Your order has been placed successfully!'
        WebElement success = driver.findElement(By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']"));
        Assert.assertTrue(success.isDisplayed());
        
        //16. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
        
        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        String Delete = driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
		System.out.println(Delete);
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
    }
}
