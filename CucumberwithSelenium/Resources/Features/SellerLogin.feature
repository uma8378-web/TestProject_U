Feature: Functionalities of Bidder login - pages navigation on eBidding Application
 
Scenari1: Verification of Seller login
Given Open the Firefox and launch the application
When Enter the Username and Password
Then Login to the Application

Scenario2:Add product details
Given Add new Product
When Enter Product Details
Then Poduct added

Scenario3:View Product details
Given View Productr Details
When Click on ViewdProduct link in the header
Then Displays the Product list with below details

Scenario4:Delete a Closed bid products
Given Seller can Delete a Close bid product
When Delete products have biddingstatus Closed
Then Navigate to View Product page and listed open products

Scenario4:View Winning product Details
Given Bid a product by Bidder
When Bid products by click on link Bid
when enter bid detail and click
Then Bidding done and bidding status updated to the product

Scenario6:Logout application
When Bidder LogOut from the Application
When By clicking Logout link
Then Logout the Application