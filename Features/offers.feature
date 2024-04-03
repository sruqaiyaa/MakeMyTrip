Feature: MakeMyTrip login
Scenario: Select Alloffers offers
Given I am on MakeMyTrip App Login Page
When I scroll down 
And I click on Alloffers
And I click on one of the offer
And I navigate to the offer page
Then I can see the Alloffers

Scenario: Select Hotels offers
Given I am on MakeMyTrip App Login Page
When I scroll down 
And I click on Hotels offers 
And I can see all the offers related to hotels
And I click on the offer
And I navigate to the hotels offer page
Then I can see the Hotels offers

Scenario: Select Banks offers
Given I am on MakeMyTrip App Login Page
When I scroll down 
And I click on Banks offers 
And I can see all the offers related to Banks
And I click one of the offer
And I navigate to banks offer page 
Then I can see the Banks offers

Scenario: Select Trains offers
Given I am on MakeMyTrip App Login Page
When I scroll down 
And I click on Trains 
And I can see all the offers related to trains
And I click on the the offer
Then I navigate to the trains offer page

Scenario: Select Trains filter
Given I am on MakeMyTrip App Login Page
When I scroll down 
And I click on Trains 
And I can see all the offers related to trains
And I click on the the offer
And I scroll down
And I select the filter as April 
And I scroll down 
Then I can see the offer



