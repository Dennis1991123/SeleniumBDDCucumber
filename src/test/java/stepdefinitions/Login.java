package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.HomePage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

public class Login extends Base {

	public WebDriver driver;
	public LandingPage lpage;
	public HomePage hpage;
	public LoginPage login;

	@Given("^Open any browser$")
	public void open_any_browser() throws Throwable {
		driver = initializaDriver();
		driver.get(prop.getProperty("url"));
	}

	@When("^User enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enter_username_as_something_and_password_as_something(String username, String password)
			throws Throwable {
		login = new LoginPage(driver);

		login.email().sendKeys(username);
		login.password().sendKeys(password);
		Thread.sleep(3000);
	}

	@Then("^User is able to successfully login to the page$")
	public void user_is_able_to_successfully_login_to_the_page() throws Throwable {
		hpage = new HomePage(driver);

		org.testng.Assert.assertTrue(hpage.homelink().isDisplayed());
	}

	@And("^Navigate to Login page$")
	public void navigate_to_login_page() throws Throwable {
		lpage = new LandingPage(driver);
		lpage.myAccountDropDown().click();
		lpage.loginButton().click();
		Thread.sleep(3000);
	}

	@And("^User click on Login button$")
	public void user_click_on_login_button() throws Throwable {
		login = new LoginPage(driver);
		login.loginbutton_signup().click();
		Thread.sleep(3000);

	}

	 @After
	    public void closeBrowser(){
	        try{
	        driver.quit();
	        } catch(NullPointerException e){
	            System.out.println("NullPointerException thrown!");
	        }
	    }

}
