package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCreatedAccountPage {
	WebDriver driver;

	public NewCreatedAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1")
	private WebElement registerText;

	public void getNewRegisterText() {
		registerText.getText();
	
}
	}
