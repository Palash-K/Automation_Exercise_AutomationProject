package automationExercises;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC06AutomationExercises {
	// Test Case 6: Contact Us Form
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
    public void test1() throws InterruptedException, AWTException {
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch = driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']"));
        Assert.assertTrue(getInTouch.isDisplayed());

        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test15@mail.com");
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("test");
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Selenium");

        //7. Upload file
        WebElement uploadFile = driver.findElement(By.xpath("//input[@name='upload_file']"));
        uploadFile.sendKeys("C:\\Users\\HP\\Desktop\\Swag_Labs.xlsx");

        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //9. Click OK button
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        //Robot robot = new Robot();
        //robot.keyPress(KeyEvent.VK_ENTER);

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Thread.sleep(2000);
        WebElement successMessage = driver.findElement(By.xpath("(//*[text()='Success! Your details have been submitted successfully.'])[1]"));
        Assert.assertTrue(successMessage.isDisplayed());

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//span[normalize-space()='Home']")).click();
        WebElement homePages = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePages.isDisplayed());


    }
}
