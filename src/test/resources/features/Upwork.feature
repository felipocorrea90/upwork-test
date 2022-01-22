Feature: Upwork Test Automation Test

  Scenario: Run Upwork Test Automation Test using Google search engine
    Given user goes to Google website using "Chrome"
    When user searches for "testing"
    And saves the first 10 items
    Then at least one attribute of each item contains searched keyword

  Scenario: Run Upwork Test Automation Test using Duck search engine
    Given user goes to Duck website using "Chrome"
    When user searches for "testing"
    And saves the first 10 items
    Then at least one attribute of each item contains searched keyword

  Scenario: Compare search engines results
    Then show duplicated items from both search engines results
