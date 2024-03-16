Feature: Add to Cart

  Scenario Outline: To add a t-shirt in wishlist
    Given user is on the google home page
    When user searched with <SiteName> in search bar
    And user clicks the first option from suggestion
    And user clicks the first option from the page
    Then user verifies that the site is Amazon.in official
    When user search <ProductType> in search bar
    And user select the price range from price section
    And select the <ProductNumber> product
    And click on add to cart button
    And delete product from cart

    Examples:
      | SiteName | ProductType |ProductNumber|
      |  Amazon  |  tshirt     | third       |



