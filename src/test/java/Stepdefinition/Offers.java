package Stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import MyPageFactory.TripOffers;

public class Offers {
	
	WebDriver driver;
	
	@Given("I am on MakeMyTrip App Login Page")
	public void i_am_on_make_my_trip_app_login_page() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement frame = driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-frame']"));
		driver.switchTo().frame(frame); 
		WebElement clsBtn =driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", clsBtn);
	}

	@When("I scroll down")
	public void i_scroll_down() throws InterruptedException {
		String parent_WindowHandle=driver.getWindowHandle();
	    driver.switchTo().window(parent_WindowHandle);
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
	}

	@When("I click on Alloffers")
	public void i_click_on_alloffers() {
	    
	}

	@When("I click on one of the offer")
	public void i_click_on_one_of_the_offer() throws InterruptedException {
		TripOffers obj = new TripOffers(driver);
		obj.allOffers();
        String child_tab="";
        Set<String> child= driver.getWindowHandles();
        for(String child_handle:child) {
        	child_tab=child_handle;
        }
        driver.switchTo().window(child_tab);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
	}

	@When("I navigate to the offer page")
	public void i_navigate_to_the_offer_page() {
	    
	}

	@Then("I can see the Alloffers")
	public void i_can_see_the_alloffers() {
		String expected="Up to 40% OFF* on Premium Hotels, Homestays & Villas!";
		String actual= driver.findElement(By.xpath("//p[text()='Up to 40% OFF* on Premium Hotels, Homestays & Villas!']")).getText();
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion is done");
	}

	@When("I click on Hotels offers")
	public void i_click_on_hotels_offers() throws InterruptedException {
	    String parentWindowHandle11=driver.getWindowHandle();
		driver.switchTo().window(parentWindowHandle11);
		TripOffers obj = new TripOffers(driver);
		obj.hOtels();
	}

	@When("I can see all the offers related to hotels")
	public void i_can_see_all_the_offers_related_to_hotels() {
	    
	}

	@When("I click on the offer")
	public void i_click_on_the_offer() throws InterruptedException {
		TripOffers obj = new TripOffers(driver);
		obj.summeroffers();
		String child_tab1="";
        Set<String> child1= driver.getWindowHandles();
    	for(String child_handle:child1) {
    		child_tab1=child_handle;
    		}
		driver.switchTo().window(child_tab1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	@When("I navigate to the hotels offer page")
	public void i_navigate_to_the_hotels_offer_page() {
	    
	}

	@Then("I can see the Hotels offers")
	public void i_can_see_the_hotels_offers() {
		String title=driver.getTitle();
		System.out.println(title);
	}

	@When("I click on Banks offers")
	public void i_click_on_banks_offers() throws InterruptedException {
	    String parentWindowHandle11=driver.getWindowHandle();
		driver.switchTo().window(parentWindowHandle11);
		TripOffers obj = new TripOffers(driver);
		obj.Bank();
	}

	@When("I can see all the offers related to Banks")
	public void i_can_see_all_the_offers_related_to_banks() {
		
	}

	@When("I click one of the offer")
	public void i_click_one_of_the_offer() throws InterruptedException {
		TripOffers obj = new TripOffers(driver);
		obj.Boffers();
		String child_tab1="";
		Set<String> child1= driver.getWindowHandles();
    	for(String child_handle:child1) {
    		child_tab1=child_handle;
    	}
    	driver.switchTo().window(child_tab1);
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		js.executeScript("window.scrollBy(0,300)");
	}

	@When("I navigate to banks offer page")
	public void i_navigate_to_banks_offer_page() {
	    
	}

	@Then("I can see the Banks offers")
	public void i_can_see_the_banks_offers() {
		String expected="OFFER DETAILS:";
		String actual= driver.findElement(By.xpath("//h3[text()='Offer Details:']")).getText();
		Assert.assertEquals(actual, expected);
		System.out.println("Offer is available");
	}

	@When("I click on Trains")
	public void i_click_on_trains() throws InterruptedException {
		TripOffers obj = new TripOffers(driver);
		obj.triptrains();
	}

	@When("I can see all the offers related to trains")
	public void i_can_see_all_the_offers_related_to_trains() {
	   
	}

	@When("I click on the the offer")
	public void i_click_on_the_the_offer() {
		TripOffers obj = new TripOffers(driver);
		obj.tripTrainOffer();
	}

	@Then("I navigate to the trains offer page")
	public void i_navigate_to_the_trains_offer_page()  {
	 
	}

	@When("I select the filter as April")
	public void i_select_the_filter_as_april() throws InterruptedException {
		String child_tab11="";
	      Set<String> child11= driver.getWindowHandles();
	  	for(String child_handle:child11) {
	  		child_tab11=child_handle;
	  		}
		driver.switchTo().window(child_tab11);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
	    TripOffers obj = new TripOffers(driver);			
	    obj.filter();
	}

	@Then("I can see the offer")
	public void i_can_see_the_offer() {
		
	}
}
	