package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EntryAd {

		// TODO Auto-generated method stub
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		//System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver.get("https://the-internet.herokuapp.com/");
		
	}
	
	@Test
	public void EntryAdModalWin() {
		
		driver.findElement(By.linkText("Entry Ad")).click();
		JavascriptExecutor js  = (JavascriptExecutor)driver;
		String modalTitle =  (String) js.executeScript(" return document.querySelector(\".modal-title\").innerText");
		Assert.assertEquals(modalTitle.trim(), "This is a modal window");
		
	    //js.executeScript("document.querySelector('div.modal > div.modal-footer').click()");	
		
	}
	
	 @AfterTest 
	 public void endSession() { 
		 driver.quit();
	 }
	 
}
