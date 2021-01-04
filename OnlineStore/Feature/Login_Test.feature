Feature: Login Action

Scenario: Login to amazon india site
	Given User launches amazon site
	And User enters username and password
	When User clicks on sign in button
	
Scenario: Login to amazon india site with invalid username
	Given User launches amazon site
	And User enters invalid username and click on continue
	When User verifies username is invalid