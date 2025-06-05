#This file to declare the test cases in end user/stake holder understandable format

Feature: GeoCallTest Application Smoke Testing Automation Suite

#  Here the scenario is to login to GeoCallTest application


####################################  Validating the test scenarios on ***  Dashboard page  *** ####################################

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

    # Validating test cases on Home Owner Ticket flow
  Scenario: Validate the GeoCall Test Application launch
    Given GCT application URL to launch
    When user gets the HomeOwnerTicket Page
    Then Home Owner ticket option should be there



####################################  Validating the test scenarios on ***  SignIn page  *** ####################################

    # Login and log out of the application
  @LoginLogout
  Scenario: Validate GCT application Login and Logout
    Given GCT application URL to launch
    Then User Login to the application
    Then User logout


####################################  Validating the test scenarios on ***  Ticket Search Page  *** ####################################

  # Validating test cases on Ticket Search flow
  Scenario: Validate the Ticket Search Functionality
    Given GCT application URL to launch
    Then User Login to the application
    Then Go to the Menu and click on ticket search
    Then Check whether ticket search is visible or not
    Then Click on ticket search and enter ticket number as "20222230002"