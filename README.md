# Checkout

The Checkout class is implemented in the format given in the test file.
To initialise the class, a list of promotional rules are applied to the checkout basket.

There are 2 types of discount rule implemented -
 - The checkout can scan every item and applies an item level discount.
 - While there is also the availability of cart level discount
 
 The discount can be of 2 types -
 - percentage based, works based on the percentage price of the entities
 - absolute based, works on a direct amount
 
 The code was implemented in Java first and then translated to based Ruby code.
 
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
  
 To install dependencies
 ```
bundle install
```

### Running Tests
 ```
bundle exec rspec
```
 
 * Ruby Version: 2.5.1
