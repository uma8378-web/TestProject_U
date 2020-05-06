Feature: Functionalities of Bidder login - pages navigation on eBidding Application
 
Scenari1: Verification of Bidder login
Given Open the Firefox and launch the application
When Enter the Username and Password
Then Login to the Application

Scenario2:Add Bidder details
Given Add New Bidder
When Enter Bidder Details in Bidder page
Then Bidder added

Scenario3:View Bidder details
Given View Bidder Details
When click on ViewBidder link in the header
Then Displays the Bidder details

Scenario4:View Product details
Given View Productr Details
When Click on ViewdProduct link in the header
Then Displays the Product list with below details

Scenario5:Bid a Product
Given Bid a product by Bidder
When Bid products by click on link Bid
when enter bid detail and click
Then Bidding done and bidding status updated to the product

Scenario6:Logout application
When Bidder LogOut from the Application
When By clicking Logout link
Then Logout the Application