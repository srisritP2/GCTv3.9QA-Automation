package StepDefnitions;

import com.qa.base.TestBase;
import com.qa.pages.Login;
import com.qa.util.TestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.apache.xmlbeans.SystemProperties.getProperty;

public class LoginPageSteps extends Login {
    public LoginPageSteps() {
        PageFactory.initElements(driver, this);
    }
    public Login Login = new Login();

    //    @Given("GCT application URL to launch")
//    public void gct_application_url_to_launch() throws InterruptedException {
//        String Title = getDashboardPageTitle();
//        System.out.println("GCT Application is launched with given URL And Title is " + Title);
//    }

    private WebDriver driver;

    public LoginPageSteps(WebDriver driver) {
//        this.driver = ApplicationHooks.getDriver(); // Get WebDriver instance from Hooks
        LoginPageSteps loginPage = new LoginPageSteps(this.driver);
    }

//    @Given("GCT application URL to launch")
//    public void launch_application() {
//        driver.get(TestUtil.getProperty("app.url"));
//    }

    @Then("Enter Valid User name as")
    public void enter_username() {
        enterUsername(prop.getProperty("username"));
    }

    @Then("Enter Valid Password as")
    public void enter_password() {
        enterPassword(prop.getProperty("password"));
    }

    @Then("User clicks on Login button")
    public void click_login() {
        clickLogin();
    }
    @Then("User Login to the application")
    public void user_login_to_the_application() throws InterruptedException {
        Thread.sleep(5000);
        enterUsername(prop.getProperty("username"));
        enterPassword(prop.getProperty("password"));
        clickLogin();
    }

    @When("User gets the GCT Home Page")
    public void user_gets_the_gct_home_page() {
        redirectToHomePage();
    }

    @Then("User redirects to sign in Page")
    public void user_redirects_to_sign_in_page() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(isLoginButtonExists());
        clickOnLoginMenuButton();
    }

    @Then("Enter Invalid User name as {string}")
    public void enter_invalid_user_name_as(String username) throws InterruptedException {
        enterUserName(username);
    }
    @Then("Enter Valid User name as {string}")
    public void enter_valid_user_name_as(String username) throws InterruptedException {
        enterUserName(username);
    }

    @Then("Enter Valid Password as {string}")
    public void enter_valid_password_as(String password) {
        enterUserPassword(password);
    }

    @Then("Click on I agree terms and conditions")
    public void click_on_i_agree_terms_and_conditions() {
        iAgreeToTermsAndConditions();
    }

//    @Then("User clicks on Login button")
//    public void user_clicks_on_login_button() throws InterruptedException {
//        clickOnLogin();
//    }
    @Then("User redirects to Dashboard page")
    public void user_redirects_to_dashboard_page() {
        userRedirectedToDashboard();
    }

    @Then("Application should not allow the user to login")
    public void application_should_not_allow_the_user_to_login() {
        System.out.println("Error: Invalid Username or Password and Sign is not Successful");
    }

    @Then("User click on Submit button")
    public void user_click_on_submit_button() {
        clickOnSubmitButton();
    }

    @Then("Click on the Forgot Password link")
    public void click_on_the_forgot_password_link() {
        clickOnForgotPasswordLink();
    }

    @Then("Check whether the forgot password window displayed to the user")
    public void check_whether_the_forgot_password_window_displayed_to_the_user() {
        Assert.assertTrue(isForgotPasswordWindowExists());
    }

    @Then("Check whether the Email field is enabled")
    public void check_whether_the_email_field_is_enabled() throws InterruptedException {
        Assert.assertTrue(isEmailFieldEnabledOnResetPassword());
    }

    @Then("Check Submit button is enabled")
    public void check_submit_button_is_enabled() {
        Assert.assertTrue(isSubmitButtonsExists());
    }

    @Then("Enter a anonymous email as {string}")
    public void enter_a_anonymous_email_as(String AnonymousEmail) throws InterruptedException {
        Thread.sleep(3000);
        enterAnonymousEmail(AnonymousEmail);
    }

    @Then("Click on Submit button")
    public void click_on_submit_button() {
        clickOnSubmitButton();
    }

    @Then("Check whether the application displaying an error message")
    public void check_whether_the_application_displaying_an_error_message() {
        Assert.assertTrue(validateWithAnonymousEmail());
    }

    @Then("Enter a valid email as {string}")
    public void enter_a_valid_email_as(String validEmailID) {
        enterValidEmail(validEmailID);
    }

    @Then("Check whether user notified with acknowledgement on successful submission and Login button")
    public void check_whether_user_notified_with_acknowledgement_on_successful_submission_and_login_button() {
        successAckForgotPassword();
    }
}