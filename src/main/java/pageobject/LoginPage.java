package pageobject;

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

	@FindBy(name = "email")
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(css = "input[value='Login']")
	WebElement loginbutton_signup;

	public WebElement email() {
		return email;
	}

	public WebElement password() {
		return password;
	}

	public WebElement loginbutton_signup() {
		return loginbutton_signup;
	}

}
