package FionTest.Demo1Maven.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FionTest.Demo1Maven.AbstractComponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	@FindBy(css="hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage() {
		return confirmationMessage.getText();
	}
}
