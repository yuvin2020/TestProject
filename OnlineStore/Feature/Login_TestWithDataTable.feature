Feature: Login Action with data table

Scenario: Login to amazon india site with data table 
	Given User launches amazon site
	And User enters username and password using data table
	| 9962986991	| yuvin2020		|
	When User clicks on sign in button
	
Scenario: Login to amazon india site with data table header 
	Given User launches amazon site
	And User enters username and password using data table mapping
	| username		| password 		|
	| 9962986991	| yuvin2020		|
	When User clicks on sign in button
	
Scenario: Login to amazon india site with data table and object class 
	Given User launches amazon site
	And User enters username and password using data table and object class
	| username		| password 		|
	| 9962986991	| yuvin2020		|
	When User clicks on sign in button