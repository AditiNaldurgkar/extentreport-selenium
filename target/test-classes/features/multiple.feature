Feature: Login functionality on DemoQA

  Scenario Outline: Verify login with multiple credentials
    Given user is on login page
    When user enters "<username>" and "<password>"
    And user clicks on login button
    Then user should see "<result>"

  Examples:
    | username     | password     | result            |
    | testuser1    | pass123      | Login Successful  |
    | testuser2    | wrongpass    | Login Failed      |
    | invaliduser  | pass123      | Login Failed      |
    |              | pass123      | Login Failed      |
    | testuser3    |              | Login Failed      |