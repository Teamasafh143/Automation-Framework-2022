Feature: User Login verification
  Scenario: Verify user is able to login into automationpractice site for valid credentials
  Given I launch automationpractice website
    When I click the 'Sign in' button in the automationpractice launch page
    And I enter 'ateamtester@example.com' as valid login email in the SignIn page
    And I enter 'team1234' as valid login password in the SignIn page
    And I select the 'Sign in' button in the automationpractice page
    Then I verify the title  in the automationpractice homepage


  Scenario : Verify user is not able to login into automationpractice site for invalid credentials
    Given I launch automationpractice website
    When I click the 'Sign in' button in the automationpractice launch page
    And I enter "<LoginEmail>" as invalid login email in the SignIn page
    And I enter "<LoginPassword>" as invalid login password in the SignIn page
    And I select the 'Sign in' button in the automationpractice page
    Then I verify the display of login failed error message in the login page
