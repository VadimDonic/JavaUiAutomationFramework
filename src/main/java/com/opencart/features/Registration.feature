Feature: Register Flow Feature Test Suite


  Scenario: Access the Account Page after successful registration
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the privacy toggle is enabled
    And continue button is clicked
    Then the new page url contains "success" keyword

  Scenario: User remains on Register Page when continue button is not clicked during the register flow
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the privacy toggle is enabled
    Then the new page url contains "route=account/register&language=en-gb" keyword

  Scenario Outline: Error messages are displayed when trying to register with invalid <attribute> date
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    And the registration form is completed with the following data:
      | firstName | <firstName>          |
      | lastName  | <lastName>           |
      | email     | dima.grati@email.com |
      | password  | Random               |
    When continue button is clicked
    Then the following error messages are displayed:
      | Warning: You must agree to the Privacy Policy!   |
      | <attribute> must be between 1 and 32 characters! |
    Examples:
      | firstName                            | lastName                             | email  | password | attribute  |
      | qweqweqweqwqwrerreyrtyrtyrtyrtyryrty | random                               | random | random   | First Name |
      | Valid                                | qweqweqweqwqwrerreyrtyrtyrtyrtyryrty | random | random   | Last Name  |
