#Author: your.email@your.domain.com
Feature: Search Functionality
  I want to use this feature file to search for products

  Scenario: Search for Item
    Given User navigates to the webstaurantStore website
    When User search for stainless work table|enterText
      | ObjectName            | text                 |
      | webstaurant.searchBar | stainless work table |
    And User click on Search button  | clickObject
      | ObjectName               |
      | webstaurant.searchButton |
    And User verify search results contain word Table | verifyWebListText
      | ObjectName                | expectedValue |
      | webstaurant.productTitles | Table         |
    And User click last item  | clickOnLastItem
      | ObjectName                |
      | webstaurant.productTitles |
    And User add item to the cart  | clickObject
      | ObjectName            |
      | webstaurant.addToCart |
    And User click to view item in the cart | clickObject
      | ObjectName           |
      | webstaurant.viewCart |
    And User click on empty cart button | clickObject
      | ObjectName                  |
      | webstaurant.emptyCartButton |
    Then User confirm to empty the item in the cart | clickObject
      | ObjectName                         |
      | webstaurant.confirmEmptyCartButton |
    And User verify the cart is empty | verifyText
      | ObjectName                | expectedValue       |
      | webstaurant.emptyCartText | Your cart is empty. |
