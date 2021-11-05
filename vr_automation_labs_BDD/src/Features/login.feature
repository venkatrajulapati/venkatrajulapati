#Author: venkata.rajulapati@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Verify Login Functionality
 
  
  Scenario: verify Login with valid credentials
    Given Launch CRM Application
    When CRM Home page is Loaded
    Then Enter "venkata.rajulapati@gmail.com" and "05jun1984" and click on Login
    
  Scenario Outline: verify Login Functionality
    Given GetTestData
    			|SheetName|Keyname|
    			|Login|verify Login Functionality|
    Given Launch CRM Application
    When CRM Home page is Loaded
    Then Enter Username and Password and click on Login <DataRow>
    
  Examples:
			|DataRow|
    	|1|
    	|2|
    	|3|