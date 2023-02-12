package FionTest.Demo1Maven.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import FionTest.Demo1Maven.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;

		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	public Boolean verifyProductDisplay(String productName) {
		
		Boolean match =	cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		return match;
	}
	
	public void goToCheckout() {
		checkoutEle.click();
	}

}
