## Overview

This project contains solution for pre-interview Excercise for **Capgemini QA candidates**. The solution is implemented using Selenium, Java7, JUNIT, Maven and Cucumber JVM framework in a BDD setup.

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
3. Open Config.java and select the browser required
4. Open DriverClient.java and set the following System Properties. 
  *  System.setProperty("webdriver.chrome.driver", "/path/of/chromedriver");
  *  System.setProperty("webdriver.firefox.bin", "/path/of/firefox/bin");
3. Assuming Maven is installed in your machine, open terminal (or command prompt if using windows)
4. run  `mvn clean`from command line
5. run `mvn test` from command line

## Framework explained
Framework is designed using Page Object Model where each page is designed as a class in Java and all the operations on that page are defined as methods. <br/>

This has several advantages
  *  The code is user readable
  *  The complexity of implementation can be moved to the back end and encpsulated from step defenitions
  *  Scenarios can be defined using feature files along with business analysts and other non technical stake holders. 
  *  Reuse common functionalities across the framework
  *  Any changes to System-Under-Test needs modification of only the page classes and not the test cases. 

Since we have only one page here, I have defined it as **HomePage.java**

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

## Step Definitions

Step definitions is where all the Gherkin lines in `.feature` file is implemented. If we run the feature file, the cucumber -JVM gives all the pending step definitions which can be used as a starting point. <br/>

In this case I have only one StepDef called **HotelBookingStepDefs.java**. There has to be a matching step defenitions for each step in *.feature file. When Junit runs the cucumber tests, it first looks for feature file and then maps it to corresponding step defenitions. <br/>

I create an Object of HomePage.java and do all the operations on it in HotelBookingStepDefs.java. <br/>


## Test Runner

We need to define a TestRunner to override the default JUNIT test runner and make the tests run using CucumberRunner. This is done in *RunCucumberTest.java* class file. <br/>
Just use the `@RunWith` junit tag and to to this and pass the Cucumber.class binary. <br\>

Also we can set different Cucumber options like tags, feature file locations, reports using `@CucumberOptions` tag

## Test cases - Feature file

Finally the tests are defined using several *.feature files. Ironically this is the first file to be written! But in this description I am coming to it in the end as I covered the framework classes first. <br\>

I have created a feature file called **HotelBooking.feature**. It has the three test cases to be run <br\>

`Background` is used to add the `Given` statement which is common to all three tests which logs in to the system. 

1. Create an entry testcase
  *  I have hardcoded all the values to be entered inline with Gherkin Given When Then statments. 
  *  Assertion is added in stepdef to check if the hotel entry is added as the last line of the table. 
  
2. Delete an entry testcase
  *  I take the Hotel Name as input in this file and send it to stepdef to delete the correspondig row
  *  Multipule hotels with the same name is also deleted and not just the first one. 
  * Assertion is added in stepdef to check if all the hotels with that name is deleted. 
  
3. Creation of Multiple Entries Testcase
  * I have used **Scenario Outline** cucumber feature to pass 5 hotel entries. 
  * Each entry is added one by one
  * reused the assersions from test case 1 to make sure hotels are added. 
  




