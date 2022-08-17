package StepDefnitions;

import com.qa.pages.dashBoard;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class DashBoardPageSteps {

    WebDriver driver;
    dashBoard db;
    private static String title;

//  # Validate whether the GCT is application up and running
    @Given("^GCT application URL to launch$")
    public void gct_application_url_to_launch() {
//        driver.get("https://geocalltest.progressivepartnering.com/ui/ticket/homeowner");
        System.out.println("GCT Application is launched with given URL");

    }

    @Then("^Check with P2 logo displaying or not$")
    public void check_with_p2_logo_displaying_or_not() throws InterruptedException {
        Assert.assertTrue(dashBoard.isP2LogoExist());
    }
    @Then("^Check Sign in and Register buttons are displayed or not$")
    public void check_sign_in_and_register_buttons_are_displayed_or_not() throws InterruptedException {
        Assert.assertTrue(dashBoard.isSigninButtonExist());
        Assert.assertTrue(dashBoard.isRegisterButtonExist());
    }
    @Then("^Check whether the Dashboard text is displayed or not$")
    public void check_whether_the_dashboard_text_is_displayed_or_not() {
        Assert.assertTrue(dashBoard.isDashboardTextExist());
    }
    @Then("^Check whether the Menu button is displayed or not$")
    public void check_whether_the_menu_button_is_displayed_or_not() {
        Assert.assertTrue(dashBoard.isMenuButtonExist());
    }


    //    Home owner ticket option page validation

    @When("user gets the HomeOwnerTicket Page")
    public void user_gets_the_home_owner_ticket_page() throws InterruptedException {

        title =db.getHomePageOwnerTicketPageTitle();
        System.out.println("Page title is: " + title);
    }
    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("Home Owner ticket option should be there")
    public void home_owner_ticket_option_should_be_there() {
        Assert.assertTrue(db.isHWToptionIsExist());

    }


}
