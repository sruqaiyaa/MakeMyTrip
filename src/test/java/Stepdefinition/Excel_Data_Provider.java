package Stepdefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MyPageFactory.ExcelUtilities;
import MyPageFactory.TripOffers;

public class Excel_Data_Provider {

	WebDriver driver;
	@DataProvider(name = "testdata")
	public Object getData() {
		ExcelUtilities utils = new ExcelUtilities("C:\\Users\\RUQAIY\\Desktop\\OfferDetails.xlsx");
		int rows = utils.getRowCount(0);
		Object[][] logindata = new Object[rows][1];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < 1; j++) {
				logindata[i][j] = utils.getdata(0, i + 1, j);
				System.out.println(logindata[i][j]);
			}
 
		}
		return logindata;
	}
	@BeforeMethod
	public void before() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement frame = driver.findElement(By.xpath("//*[@id='webklipper-publisher-widget-container-notification-frame']"));
		driver.switchTo().frame(frame); 
		WebElement clsBtn =driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']"));
		//clsBtn.click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", clsBtn);
	    String parent_WindowHandle=driver.getWindowHandle();
	    driver.switchTo().window(parent_WindowHandle);
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		TripOffers obj = new TripOffers(driver);
		obj.allOffers();
        String child_tab="";
        Set<String> child= driver.getWindowHandles();
        for(String child_handle:child) {
        	child_tab=child_handle;
        }
        driver.switchTo().window(child_tab);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        
	}
	@Test(dataProvider="testdata")
	public void offers(String str) {
		String expected=str;
		String actual= driver.findElement(By.xpath("//p[text()='Up to 40% OFF* on Premium Hotels, Homestays & Villas!']")).getText();
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion is done");

		
	}
}
