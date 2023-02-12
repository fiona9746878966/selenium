package FionTest.Demo1Maven.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FionTest.Demo1Maven.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;

	public LandingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	//driver.findElement(By.id("userPassword")).sendKeys("Fiona123@#");
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	//driver.findElement(By.id("login")).click();
	
	@FindBy(id="login")
	WebElement submit;
	public void loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}
