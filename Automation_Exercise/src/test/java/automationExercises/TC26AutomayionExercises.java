package automationExercises;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC26AutomayionExercises {
   //Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
    WebDriver driver;
    
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterTest
    public void tearDown(){
        //driver.close();
    }
    @Test
    public void test() throws AWTException, InterruptedException {
        driver.get("http://automationexercise.com");
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
        WebElement subscription = driver.findElement(By.xpath("//*[text()='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_HOME);
        WebElement scrolledUp = driver.findElement(By.xpath("//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]"));
        Assert.assertTrue(scrolledUp.isDisplayed());


    }

}
