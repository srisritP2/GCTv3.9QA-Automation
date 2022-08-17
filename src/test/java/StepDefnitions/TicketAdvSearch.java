package StepDefnitions;

import com.qa.pages.ticketSearch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TicketAdvSearch {
    ticketSearch ticketS;

    @Given("User on Ticket Advanced Search Page")
    public void user_on_ticket_advanced_search_page() {
        String title = ticketSearch.getTicketSearchPageTitle();
        System.out.println("Accounts Page title is: " + title);
    }

    @Then("Go to the Menu and click on ticket search")
    public void go_to_the_Menu_and_click_on_ticket_search() throws InterruptedException {
        ticketS = new ticketSearch();
        ticketS.navigateToTicketSearch();
    }

    @Then("Check whether ticket search is visible or not")
    public void check_whether_ticket_search_is_visible_or_not() {
        ticketS.validateTicketSearchPageTitle();
    }

    @Then("Click on ticket search and enter ticket number as {string}")
    public void click_on_ticket_search_and_enter_ticket_number_as(String tNumber) throws InterruptedException {
        ticketS.enterTicketNumberInSearch(tNumber);
    }
}
