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

public class MultipleLogin extends Base {
	public WebDriver driver;
	public LandingPage lpage;
	public HomePage hpage;
	public LoginPage login;

	@Given("^Open browser$")
	public void open_browser() throws Throwable {
		driver = initializaDriver();
		driver.get(prop.getProperty("url"));
	}

	@And("^Navigate to Login screen$")
	public void navigate_to_login_screen() throws Throwable {
		lpage = new LandingPage(driver);
		lpage.myAccountDropDown().click();
		lpage.loginButton().click();

	}

	@When("^User enter username as (.+) and password as (.+) into the feilds$")
	public void user_enter_username_as_and_password_as_into_the_feilds(String username, String password)
			throws Throwable {
		System.out.println("username>>" + username);
		System.out.println("password>>" + password);
		login = new LoginPage(driver);

		login.email().sendKeys(username);
		login.password().sendKeys(password);

	}

	@And("^User click on signup button$")
	public void user_click_on_signup_button() throws Throwable {
		login = new LoginPage(driver);
		login.loginbutton_signup().click();

	}

	@Then("^User is able to  login int to the page$")
	public void user_is_able_to_login_int_to_the_page() throws Throwable {
		hpage = new HomePage(driver);

		org.testng.Assert.assertTrue(hpage.homelink().isDisplayed());

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
