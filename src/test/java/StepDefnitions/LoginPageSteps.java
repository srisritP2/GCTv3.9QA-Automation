package StepDefnitions;

import com.qa.base.TestBase;

import com.qa.pages.login;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps extends login {

	WebDriver driver;

	public login lp = new login();

//Scenario: Login Page UI Page's title, Sign, Register buttons
	@When("User gets the GCT Home Page")
	public void user_gets_the_gct_home_page() {
		lp.redirectToHomePage();
	}
	@Then("User verifies Sign button")
	public void user_verifies_sign_button() {
		Assert.assertTrue(lp.isSignButtonExists());
	}
	@Then("User verifies Register button")
	public void user_verifies_register_button() {
		Assert.assertTrue(lp.isRegisterButtonExists());
	}

// Scenario:Validating sign in page with valid credentials
	@When("user redirects to sign in Page")
	public void user_redirects_to_sign_in_page() {
			lp.signIn();
		}

	@Then("user enters the username as {string}")
	public void user_enters_the_username_as(String username) {
				lp.enterUserName(username);
		}

	@Then("user enters the password as {string}")
	public void user_enters_the_password_as(String password) {
			lp.enterUserPassword(password);
		}

	@Then("user click on sign in button")
	public void user_click_on_sign_in_button() {
			lp.clickOnLogin();
		}

	@Then("User logout")
	public void user_logout() throws InterruptedException {
			lp.logout();
	}
	@Then("user redirects to Dashboard page")
	public void user_redirects_to_dashboard_page() {
		Assert.assertTrue(lp.isAuthDashboardExists());
		}

	@Then("page Header should be Authenticated Dashboard Announcement")
	public void page_header_should_be_authenticated_dashboard_announcement() {
		Assert.assertTrue(lp.isAuthDashboardHeaderExists());
		}
}

