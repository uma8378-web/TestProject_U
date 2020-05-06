package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsBidder {
	
	WebDriver driver;			
		
    @Given("^Open the Firefox and launch the application$")					
    public void open_the_Firefox_and_launch_the_application() throws Throwable							
    {		
       System.setProperty("webdriver.gecko.driver", "C://Users//CSS//eclipse-workspace//CucumberwithSelenium//src//Drivers//geckodriver.exe");					
       driver= new FirefoxDriver();					
       driver.manage().window().maximize();			
       driver.get("http://localhost:8091/maven.servlet.bidding/");	
       System.out.println("This Step open the Firefox and launch the application.");
    }		

    @When("^Enter the Username and Password$")					
    public void enter_the_Username_and_Password() throws Throwable 							
    {		
       driver.findElement(By.name("uid")).sendKeys("sanj@gmail.com");							
       driver.findElement(By.name("password")).sendKeys("sanj123");							
    }		

    @Then("^Login to the Application$")					
    public void Login_to_the_Application() throws Throwable 							
    {		
       driver.findElement(By.name("btnLogin")).click();					
    }		

	@Given("^Add New Bidder$")				
    public void Add_new_Bidder() throws Throwable							
    {		
	   System.out.println("Navigated to Add bidder page");		
    }	
  	 @When("^Enter Bidder Details in Bidder page$")					
   	    public void enter_Bidder_details_in_bidder_page() throws Throwable 							
    	    {	
  		 	driver.findElement(By.linkText("Add Bidder")).click();
  		  System.out.println("Add bidder page displayed");
    	       driver.findElement(By.name("Name")).sendKeys("Sanjith");							
    	       driver.findElement(By.name("Email Address")).sendKeys("sanj@gmail.com");							
    	       driver.findElement(By.name("Postal")).sendKeys("Chn-19");							
    	       driver.findElement(By.name("Mobile number")).sendKeys("9537465347");
    	       driver.findElement(By.name("Add Bidder")).click();	
    	 }				
  	@Then("^Bidder added$")					
    public void Bidder_added() throws Throwable 							
    {    				
	   System.out.println("Bidder added successfully");					
    }	
  	
    @Given("^View Bidder Details$")	
    public void View_Bidder_Details() throws Throwable							
    {		
    	System.out.println("Bidder Details");
    }
    @When("^click on ViewBidder link in the header$")	
    public void click_on_ViewBidder_link_in_the_header() throws Throwable							
    {		
    	driver.findElement(By.linkText("View Bidderr")).click();	
     }	
    @Then("^Displays the Bidder details$")
    public void displays_the_Bidder_details() throws Throwable
    {
    	List<WebElement> viewbidders = driver.findElements(By.xpath("//input[@placeholder='Id,Name,Email,Mobile']"));
    	System.out.println(viewbidders);	
    	System.out.println("Added Bidders are displayed successfully");	
    	}
          
    @Given("^View Productr Details$")	
    public void View_Product_Details() throws Throwable							
    {		
    	System.out.println("Product Details");
    } 
    @When("^Click on ViewdProduct link in the header$")				
    public void click_on_ViewProduct_link_in_the_header() throws Throwable							
    {		
    	driver.findElement(By.linkText("View Product")).click();				
    }	
    @Then("^Displays the Product list with below details$")
    
    public void displays_the_Product_list_with_below_details() throws Throwable
    {
    	List<WebElement> viewproducts = driver.findElements(By.xpath("//input[@placeholder='Itemno,Name,Quantity,Price']"));
    	System.out.println(viewproducts);
    }
  
    @Given("^Bid a product by Bidder$")	
    public void Bid_a_product_by_Bidder() throws Throwable							
    {		
    	System.out.println("Bid Product");
    } 
    @When("^Bid products by click on link Bid$")
    public void Bid_products_by_click_on_link_Bid() throws Throwable							
    {	
    driver.findElement(By.linkText("Bid")).click();
    driver.get("http://localhost:8091/maven.servlet.bidding/BidProduct");
	driver.navigate();
    System.out.println("Navigated to Bid Product page");
    }
    
    @When("^Enter bid details$")
    	public void enter_bid_details() throws Throwable
    	{
 		driver.findElement(By.name("Itemno")).sendKeys("DD-12");							
		driver.findElement(By.name("Name")).sendKeys("watch");									
		driver.findElement(By.id("Bidprice")).sendKeys("400");
		driver.findElement(By.id("Bidderid")).sendKeys("3");
		driver.findElement(By.name("btnBid")).click();	
		}	

	@Then("^Bidding done and bidding status updated to the product$")
	     public void Bidding_done_and_bidding_status_updated_to_the_product() throws Throwable 							
	     {		
	       driver.get("http://localhost:8091/maven.servlet.bidding/ViewProduct");
	    	driver.navigate();
	    	System.out.println("Navigated to View product page");
    	 }
@Given("^Bidder LogOut from the Application$")
	public void Seller_LogOut_from_the_Application() throws Throwable {
	driver.findElement (By.linkText("Logout")).click();
	}
@When("^By clicking Logout link")
public void By_clicking_LogOut_link() throws Throwable {
driver.findElement (By.linkText("Logout")).click();
}

@Then("^Logout Successfully$")
public void Logout_Successfully() throws Throwable {
       System.out.println("LogOut Successfully");
       }
}

