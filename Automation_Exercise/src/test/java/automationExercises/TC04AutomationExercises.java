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

public class TC04AutomationExercises {
	// Test Case 4: Logout User
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
    public void test1(){
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        WebElement loginTitle = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        Assert.assertTrue(loginTitle.isDisplayed());
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("test15@mail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("passwords");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        WebElement logged = driver.findElement(By.xpath("//li[9]//a[1]"));
        Assert.assertTrue(logged.isDisplayed());
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
        WebElement loginScreen = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        Assert.assertTrue(loginScreen.isDisplayed());
    }
}
