	Feature: Login test for scenario outline 
	
	Scenario Outline: Login to amazon india site with invalid username
	Given User launches amazon site
	And User enters invalid "<username>" and click on continue
	When User verifies username is invalid
	
	Examples:
	| username	|
	| Yuvin		|
	| Kanchana	|
	| Dharma	|