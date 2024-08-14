Feature: Technical challenge

  @everlap
  Scenario: Get passcode successfully
    Given I longin with user and password
      | user     |                                           895746 |
      | password | 10df2f32286b7120MS00LTY0NzU5OA==30e0c83e6c29f1c3 |
    When I complete the evert questions
    Then I can  see the passcode successfu
