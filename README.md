# Checkout
 
 The code was implemented in Java first and then translated to basic Ruby code.

The Checkout class is implemented in the format given in the test file.
To initialise the class, a list of promotional rules are applied to the checkout basket.
 
 The Checkout class calculates the total price of the checkout basket.
 The storage of the checkout items is done in a map to optimise efficiency in fetching item bucket. It stores a Checkout Item, an enhanced formation of Item class which can also implement the item level discounts.
 When the total price is evaluated, the item level discount is applied on items and then cart level discount is applied on the cart.
 
 The Promotional Rules which are essentially discount rules, can be applied using *Strategy Pattern* 
 - Item Value Discount - The checkout can scan every item and applies an item level discount.
 - Cart Value Discount - While there is also the availability of cart level discount.
 
 Each promotional rule has a rule discount value, which helps us calculate the discount on the entity.
 The discount can be of 2 types -
 - PERCENTAGE -  works based on the percentage price of the entities
 - ABSOLUTE - works on a direct amount
 
 The Promotional Rule Factory evaluates and returns the different and most optimised data types to handle the promotional rules applied.
 It has the `getItemRuleMap` to return the map of associated item with the item rules.
 It has the `getCartRuleList` to return the list of cart rules applied to the cart value. 
 
 # Reading the Java Code
 The main code files are housed inside the ``` checkout-java/src/main/com/vinterior/checkout``` folder.
 The test code files are housed inside the ``` checkout-java/src/test/java/com/vinterior/checkout``` folder.
 
 All dependencies are resolved through the pom.xml file.
 
 To build
 ``` 
 mvn clean compile
 ```
 
 * Build Tool: Maven Build Tool
 * Java Version: 8
 
 ### Running Tests
 Use command `mvn test` to run all the tests.
 
 Use command `mvn -Dtest=<testFileName> test` to run a specific test file -> testFileName
 
 # Reading the Ruby Code
  The main code files are housed inside the ```checkout-ruby/lib/``` folder.
  The test code files are housed inside the ```checkout-ruby/spec``` folder.
  
  All dependencies are resolved through the gemspec file.
  
 To install dependencies
 ```
bundle install
```
 
 * Ruby Version: 2.5.1


### Running Tests
 ```
bundle exec rspec
```

## Improvements
1. Adding more test cases at the unit level to test individual file functionalities.
2. Extending the code to evaluate the promotional rule on different levels of granularity - item(atom), product-type(molecule), cart(total) to give uniformity to the total price calculation in Checkout.