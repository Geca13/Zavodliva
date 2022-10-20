Feature: LoginFeature
  This feature deals with login functionality

  Scenario: Login with valid credentials
    Given Login modal is displayed
    And Login with valid credentials
    Then New show link is displayed
