Feature: Automation web demo blaze

  @web
  Scenario: Login using valid user and password
    Given user is on login page
    And user click button login
    And user input username "AdMaulana"
    And user input password "demoblaze123"
    When user click button login new
    Then user is on homepage

  @web
  Scenario: Login using invalid email dan password
    Given user is on login page
    And user click button login
    And user input username "AdTestInvalid"
    And user input password "invalid"
    When user click button login new
    Then user able to see popup message "User does not exist."

  @web
  Scenario: Login and logout
    Given user is on login page
    And user click button login
    And user input username "AdMaulana"
    And user input password "demoblaze123"
    And user click button login new
    And user click button logout
    Then user is on login page

  @web
  Scenario: Login with the correct password without entering a username
    Given user is on login page
    And user click button login
    And user input password "demoblaze123"
    When user click button login new
    Then user able to see popup message "Please fill out Username and Password."

  @web
  Scenario: Login with the correct username without entering a password
    Given user is on login page
    And user click button login
    And user input username "AdMaulana"
    When user click button login new
    Then user able to see popup message "Please fill out Username and Password."

  