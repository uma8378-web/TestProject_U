package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsSeller {
	
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
       driver.findElement(By.name("uid")).sendKeys("admin@jtp.com");							
       driver.findElement(By.name("password")).sendKeys("admin123");							
    }		

    @Then("^Login to the Application$")					
    public void Login_to_the_Application() throws Throwable 							
    {		
       driver.findElement(By.name("btnLogin")).click();					
    }		

	@Given("^Add new Product $")				
    public void Add_new_product() throws Throwable							
    {		
	   System.out.println("Navigated to Add product page");		
    }			
  	 @When("^Enter Product Details$")					
   	    public void enter_product_details() throws Throwable 							
    	    {		
  		 	driver.findElement(By.linkText("Add Product")).click();
  			System.out.println("Navigated to Add product page");	
    	       driver.findElement(By.name("Itemno")).sendKeys("DD-12");							
    	       driver.findElement(By.name("Name")).sendKeys("watch");							
    	       driver.findElement(By.id("Quantity")).sendKeys("5");							
    	       driver.findElement(By.id("Price")).sendKeys("100");
    	       driver.findElement(By.name("Add Product")).click();	
    	          	    }			 
    @Then("^Poduct added$")		
    
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
    
    @Given("^Seller can Delete a Close bid products$")
    public void Seller_can_Delete_a_Closed_bid_products() throws Throwable							
    {	
    	System.out.println("Delete a closed bid product");
    }
   @When("^Delete products have biddingstatus Closed$")
    public void Delete_products_have_biddingstatus_closed() throws Throwable							
    {	
	   driver.findElement(By.linkText("Delete")).click();
	  System.out.println("Product deleted successfully");
    }
    @Then("^Navigate to View Product page and listed open products$")
    public void Navigate_to_View_Product_page_and_listed_open_products() throws Throwable							
    {	 
    	driver.get("http://localhost:8091/maven.servlet.bidding/ViewProduct");
     	driver.navigate();
     	System.out.println("Navigated to View product page");
    	List<WebElement> viewlatestlist= driver.findElements(By.xpath("//div"));
    	System.out.println(viewlatestlist);
    	}
    
@Given("^View Winning Bid Details$")	
public void View_winning_bid_detials() throws Throwable							
{		
	System.out.println("View Bidding Details");
} 
@When("^ViewBiddingDetails by click on link $")				
 public void ViewBiddingDetails_by_click_on_link() throws Throwable							
 {		
 	  driver.findElement(By.linkText("View Bidding Details")).click();
 	 driver.get("http://localhost:8091/maven.servlet.bidding/ViewBiddingDetails");
    driver.navigate();
 	  System.out.println("Navigated to View Bidding Details page");						
 }
@Then("^View Bidding details$")				
 public void View_Bidding_detials() throws Throwable 							
 {		
 	List<WebElement> biddingproducts = driver.findElements(By.xpath("//input[@placeholder='Itemno,Name,Quantity,BidPrice,Bidderid,Biddingdate,Biddingstatus']"));
 	System.out.println(biddingproducts);
 }	

@Given("^Seller LogOut from the Application$")
public void SellerLogOut_from_the_Application() throws Throwable {
driver.findElement (By.linkText("Logout")).click();
}
@When("^Seller LogOut from the Application$")
public void Seller_LogOut_from_the_Application() throws Throwable {
driver.findElement (By.linkText("Logout")).click();
}

@Then("^Message displayed Logout Successfully$")
public void message_displayed_Logout_Successfully() throws Throwable {
       System.out.println("LogOut Successfully");
}
}







