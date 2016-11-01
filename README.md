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
4. run $mvn clean
5. run $mvn test

## Framework explained




## TestCases


