package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
@FindBy (id = "input-email")
private WebElement emailField;

@FindBy (id = "input-password")
private WebElement passwordField;
 
@FindBy (css = "button[type='submit']")
private WebElement loginButton;

@FindBy (css = ".btn-primary")
private WebElement ContinueButtonLogin;

@FindBy (id ="alert")
private WebElement alertLogin;

public void saisirEmail(String email) {
	emailField.sendKeys(email);
}
public void saisirPassword(String password) {
	passwordField.sendKeys(password);
}
public void login() {
loginButton.click();
}
public void Register() {
	ContinueButtonLogin.click();
}
public void loginWithRequiredFields(String email,String password) {
	saisirEmail(email);
	saisirPassword(password);
	login();
}
}
