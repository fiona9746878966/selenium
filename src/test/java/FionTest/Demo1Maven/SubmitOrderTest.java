package FionTest.Demo1Maven;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import FionTest.Demo1Maven.pageobjects.CartPage;
import FionTest.Demo1Maven.pageobjects.CheckOutPage;
import FionTest.Demo1Maven.pageobjects.ConfirmationPage;
import FionTest.Demo1Maven.pageobjects.LandingPage;
import FionTest.Demo1Maven.pageobjects.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {
	
	public static void main(String[] args) throws InterruptedException{
		 String productName= "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LandingPage landingpage = new LandingPage(driver);
        landingpage.goTo();	
		landingpage.loginApplication("fiona@gmail.com", "Fiona123@#");
		ProductCatalog productCatalog = new ProductCatalog(driver);
		List<WebElement>products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
		productCatalog.goToCartPage();
		
		Thread.sleep(2000);
		
		CartPage cartPage = new CartPage(driver);
		Boolean match=cartPage.verifyProductDisplay(productName);
		
		System.out.println(match);
		
		
		
		
	Assert.assertTrue(match);

	//Thread.sleep(5000);
	cartPage.goToCheckout();
	CheckOutPage checkOutPage = new CheckOutPage(driver);
	checkOutPage.selectCountry("india");
	checkOutPage.submitOrder();
	ConfirmationPage confirmationPage = new ConfirmationPage(driver);
//	Actions a = new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//	driver.findElement(By.cssSelector(".action__submit")).click();
	
	String confirmMessage=confirmationPage.getConfirmationMessage();

	Assert.assertEquals(confirmMessage,  "Thankyou for the order." );
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	
	}

}
