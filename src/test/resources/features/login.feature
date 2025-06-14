Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given I open the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be logged in successfully
