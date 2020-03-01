Feature: AddBasket Feature
  This feature deals with user will do a search on the search screen a
  nd a selected product will be added to the basket from two different vendors

  Scenario: Adding product to the basket with logging in the user
   Given User go to home page
    And User go to login page
    And User enter "hepsiburada35@yopmail.com" and "test123" credentials
    And User enter login button
    And User enter "telefon" on search box
    And User select first product on the list
    When For the selected product, Add to basket for two vendors
    Then Check Product in the basket and Logout

