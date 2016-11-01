## Overview

This project contains solution for pre-interview Excercise for **Capgemini QA candidates**. The solution is implemented using Selenium, Java7, JUNIT, Maven and Cucumber framework in a BDD setup.

## Directory Structure

The below is the directory structure of the project which in essense is a Maven project. 

1. HotelBooking <br />
    |-- src <br />
    |-- main <br />
    |   -- java <br />
    |       -- com <br />
    |           -- capgemini <br />
    |               -- interview <br />
    |                   -- hotelbooking <br />
   *  |                       -- Config.java <br />
   *  |                       -- DriverClient.java <br />
    *  |                       -- Utilities.java <br />
    *  |                       -- HomePage.java <br />
* |-- src <br />
        |-- test <br/>
        |-- java <br />
        |    -- com <br />
        |       -- capgemini <br />
        |           -- interview <br />
        |               -- hotelbooking <br />
  *  |                   -- HotelBookingStepDefs.java <br />
  *  |                   -- RunCucumberTest.java <br />
* |-- src <br />
|-- test <br/>
        |-- resources <br />
  *  -- HotelBooking.feature <br />
* |-- pom.xml <br />


## Installation

1. In eclipse (or any IDE) create an empty maven project and place the files as per the directory structure shown above. 
2. Replace the pom.xml with the pom.xml in this repository. 
3. Assuming Maven is installed in your machine, open terminal (or command prompt if using windows)
4. run  `mvn clean`from command line
5. run `mvn test` from command line

## Framework explained
Framework is designed using Page Object Model where each page is designed as a class in Java and all the operations on that page are defined as methods. Since we have only one page here, I have defined it as **HomePage.java**

**HomePage.java**

This class file has the following features. <br/>

1. There is `@Before` cucumber hook, which initialises the driver properties and browser type as given in **Config.java**
2. The `@After` cucumber hook closes the driver after thet test 
3. There are methods to do operations on the homePage. 
  * login()  
  * enterHotelName()
  * enterAddress()
  * enterOwner()
  * enterPhoneNumber()
  * enterEmail()
  * clickCreate()
  * deleteHotel()
  
**Config.java**

This class is where we configure the url to be opened and which browser to be used to run our tests. 

**DriverClient.java**

Based on the browser configured in `Config.java` this class has the implementation of setting some basic system properties of that corresponding browser and return the driver. 

**Utilities.java**

I have a utililty class and we can add all the common utilities like taking screenshot, WaitForElement in this class which can be re used accross the framework. 

## TestCases


