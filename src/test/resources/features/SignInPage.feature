#This file to declare the test cases in end user/stake holder understandable format

Feature: GCT Application || Sign In Page || Test Cases

# Here the scenario is to login to GeoCallTest application || Dash Board Page || Test Cases
# Validating the UI test cases on dashboard page

# Validating test cases on Sign In page
  Scenario: Login Page UI Page's title, Sign, Register buttons
    Given GCT application URL to launch
    When User gets the GCT Home Page
    Then User verifies Sign button
    And User verifies Register button

# Validating login method
  Scenario:Validating sign in page with valid credentials
    Given GCT application URL to launch
    Then User Login to the application
    Then user redirects to Dashboard page
    And page Header should be Authenticated Dashboard Announcement

