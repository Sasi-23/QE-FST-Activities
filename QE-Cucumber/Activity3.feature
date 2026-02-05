@activity3
Feature: Testing With Alerts
@SimpleAlert @SmokeTest
Scenario: Testing With Simple Alert
Given User is on the page
When User clicks on the simple alert button
Then Alert opens
And Read the text from it and print it
And Close the alert
And Read the result text

@ConfirmAlert
Scenario: Testing With Confirm Alert
Given User is on the page
When User clicks on the Confirm Alert Button
Then Alert opens
And Read the text from it and print it
And Close the alert with cancel
And Read the result text

@PromptAlert
Scenario: Testing With Prompt Alert
Given User is on the page
When User clicks on the Prompt Alert Button
Then Alert opens
And Read the text from it and print it
And Write a custom message in it
And Close the alert
And Read the result text