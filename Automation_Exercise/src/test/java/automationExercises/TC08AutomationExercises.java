package automationExercises;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC08AutomationExercises {
	// Test Case 8: Verify All Products and product detail page
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
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//body"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement productPage = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(productPage.isDisplayed());

        //6. The products list is visible
        WebElement productList = driver.findElement(By.xpath("//*[@class='features_items']"));
        Assert.assertTrue(productList.isDisplayed());

        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

        //8. User is landed to product detail page
        WebElement proDetail = driver.findElement(By.xpath("//div[@class='features_items']/child::div[2]/child::div[1]/child::div[2]"));
        Assert.assertTrue(proDetail.isDisplayed());

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        List<WebElement> prodDetail = driver.findElements(By.xpath("//div[@class='product-details']"));
		for (WebElement product : prodDetail) {
			String prodName = product.getText();
			System.out.print(prodName);
		}
		System.out.println();
    }
}
