#This file to declare the test cases in end user/stake holder understandable format

Feature: GCT Application || Dash Board Page || Test Cases

#  Here the scenario is to login to GeoCallTest application || Dash Board Page || Test Cases
  # Validating the UI test cases on dashboard page

    # Validating test cases on dashboard page
  Scenario: Validate Home Page
    Given GCT application URL to launch
    Then Check with P2 logo displaying or not
    Then Check Sign in and Register buttons are displayed or not
    Then Check whether the Dashboard text is displayed or not
    Then Check whether the Menu button is displayed or not

    # Validating test cases on dashboard page
  Scenario: Validate the GeoCall Test Application launch
    Given GCT application URL to launch
    When user gets the HomeOwnerTicket Page
    Then the page title should be "GeoCall - Create New Homeowner Ticket"

  Scenario: Validate the GeoCall Test Application launch
    Given GCT application URL to launch
    When user gets the HomeOwnerTicket Page
    Then Home Owner ticket option should be there



      # Validating the Create Home Owner ticket test scenarios
  Scenario: Validate Home Owner Ticket page on Dash Board Page
    Given GCT application URL to launch
    Then Goto Home owner ticket page
    Then Click on Next and validate the user redirected to customer details page
    Then Submit the customer details and click on Next
    Then Validate whether user redirected to Lets collect location page
    Then Validate Back and Next button displayed and click on Next button
    Then Check whether user redirected to project location page
    Then Check whether user able confirm the project location details in confim page and click on Yes
    Then Check whether user able to select county
    Then Give street name if location is not found and click on Next
    Then Give directions and click on Next
    Then Validate Utility information prerequisite page is displayed
    Then Validate Project details input page is displayed and then submit with valid details
    Then Select the date of digging and click on Next
    Then Validate additional details page and Enter additional details then click on Next
    Then Validate Unusual questions page and give No to explosives and boring then click on Next
    Then Then review the ticket details and click on submit button
    Then Check whether acknowledgement is displayed



