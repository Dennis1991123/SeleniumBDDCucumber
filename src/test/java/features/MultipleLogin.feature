Feature: Login with multiple users

@MutipleUser
Scenario Outline: Login with proper username and password
Given Open browser
And Navigate to Login screen
When User enter username as <username> and password as <password> into the feilds
And User click on signup button
Then User is able to  login int to the page

Examples:
|username|password|
|dennisk1991@gmail.com|Gifty@1995|
|gifty123@gmail.com|gifty@123|



