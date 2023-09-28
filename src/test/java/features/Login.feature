Feature: Application Login

@singleUser
Scenario: Login with proper credentials
Given Open any browser
And Navigate to Login page
When User enter username as "dennisk1991@gmail.com" and password as "Gifty@1995"
And User click on Login button
Then User is able to successfully login to the page



