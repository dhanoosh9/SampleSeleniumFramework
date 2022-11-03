Feature: Verifying login functionality

  Scenario: verifying login functionality with valid credentials
    Given the user is on loginpage of the website
    When user enters username "standard_user" and password "secret_sauce"
    And Clicks on login button
    Then verify user is on homepage
