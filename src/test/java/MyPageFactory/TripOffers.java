package MyPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripOffers {
WebDriver driver;
	
	public TripOffers(WebDriver driver) {
    this.driver= driver;
    PageFactory.initElements(driver,this);
    }
	@FindBy(xpath="//p[text()='LIVE NOW:']")
	WebElement alloffers;
	@FindBy(xpath="//li[@data-cy='HOTELS']")
	WebElement hotels;
	@FindBy(xpath="//p[text()='GRAB NOW:']")
	WebElement hoteloffer;
	@FindBy(xpath="//li[@data-cy='BANK_OFFERS']")
	WebElement Banksoffers;
	@FindBy(xpath="//p[text()=\"Grab Up to Rs. 7500 OFF*\"]")
	WebElement Flights;
	@FindBy(xpath="//li[@data-cy='RAILS']")
	WebElement trains;
	@FindBy(xpath="//p[text()=' BOOKINGS ARE OPEN NOW!']")
	WebElement trainoffer;
	@FindBy(xpath="//a[@class='tabItem']")
	WebElement trainfilter;
	
	public void allOffers() {
		alloffers.click();
		
	}
	
	public void hOtels() {
		hotels.click();
	}
	
	public void summeroffers() {
		hoteloffer.click();
	}
	public void Bank() {
		Banksoffers.click();
	}
	public void Boffers() {
		Flights.click();
	}
	public void triptrains() {
		trains.click();
	}
	public void tripTrainOffer() {
		trainoffer.click();
	}
	public void filter() {
		trainfilter.click();
	}
	
	
			
}



