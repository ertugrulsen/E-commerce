Feature: AddBasket Feature
  This feature deals with user will do a search on the search screen a
  nd a selected product will be added to the basket from two different vendors

  Scenario: Adding product to the basket without logging in the user
    Given User go to home page
    And User click Uzaktan Kumandali Araclar tab
    And User filter for Drone Yedek Parça
    And User select a product in a list
    When User add product to the basket
    Then Check success notification message
