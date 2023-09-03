package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	// initialiser le WebDriver
	WebDriver driver;

	// Créer le constructeur de cette méthode pour initialiser la variable 'driver'
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Créer tous les WebElements de cette pageWeb (Register)
	// La Ceci est une annotation @FindBy fournie par le framework Selenium Page
	// Object Model (POM).
	// Elle indique à Selenium comment localiser un élément spécifique sur une page
	// web. Dans ce cas, il est indiqué que l'élément peut être localisé en
	// utilisant son attribut id avec la valeur error-firstname
	// Lorsque Selenium initialise cette variable (souvent via la méthode
	// PageFactory.initElements()), il utilise l'annotation @FindBy pour localiser
	// l'élément sur la page web et y assigner sa référence.

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "error-firstname")
	private WebElement errorFirstname;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "error-lastname")
	private WebElement errorLastname;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "error-email")
	private WebElement errorEmail;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "error-password")
	private WebElement errorPassword;

	@FindBy(id = "input-newsletter-yes")
	private WebElement inputNewsletterYes;

	@FindBy(id = "input-newsletter-no")
	private WebElement inputNewsletterNo;

	@FindBy(xpath = "input[@name='agree']")
	private WebElement privacyPolicyField;

	@FindBy(css = "btn-primary")
	private WebElement continueButton;

	@FindBy(id = "alert")
	private WebElement alertRegister;
	
	@FindBy (id = "a[@test()='login page']")
	private WebElement redirectionLink;
	
	// 4- Créer les méthodes :0: saisir les champs un a un 1:quand tt les champs
	// obligatoires sont saisies 2:
	// quans tout les champs sont saisis
	public void entrerFirstName(String firstname) {
		firstNameField.sendKeys(firstname);
	}

	public void entrerLastName(String lastname) {
		lastNameField.sendKeys(lastname);
	}

	public void entrerMail(String email) {
		emailField.sendKeys(email);
	}

	public void entrerPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void subscribe() {
		inputNewsletterYes.click();
	}

	public void unsubscribe() {
		inputNewsletterNo.click();
	}
	
	public void clickPrivatePolicy() {
		privacyPolicyField.click();
	}
	
	public void clickContinue() {
		continueButton.click();
	}
	
	public void registerWithAllFields(String firstname,String lastname,String email,String password) {
		entrerFirstName(firstname);
		entrerLastName(lastname);
		entrerMail(email);
		entrerPassword(password);
		subscribe();
		clickPrivatePolicy();
		clickContinue();	
	}
	
	public void registerWithRequiredFields(String firstname,String lastname,String email,String password) {
		entrerFirstName(firstname);
		entrerLastName(lastname);
		entrerMail(email);
		entrerPassword(password);
		clickPrivatePolicy();
		clickContinue();	
	}
	
	public String getFirstNameError() {
		return errorFirstname.getText();
	}
	
	public String getLastNameError() {
		return errorLastname.getText();
	}
	
	public String getEmailError() {
		return errorEmail.getText();
	}
	
	public String getPasswordError() {
		return errorPassword.getText();
	}
	
	public String getPrivatePolicyError() {
		return alertRegister.getText();
	}
	
	public void NavigateToLoginPage() {
		redirectionLink.click();
	}
	
}
