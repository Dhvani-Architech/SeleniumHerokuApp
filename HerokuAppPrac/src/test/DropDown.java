package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDown {
	
	WebDriver driver;
	
	
	  @BeforeTest public void setup() {
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--no-sandbox");
	  options.addArguments("--disable-dev-shm-usage");
	  options.addArguments("--headless");
	  driver = new ChromeDriver(options);
	  //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
	  driver.get("https://the-internet.herokuapp.com/"); }
	 
	
	@Test
	public void dropDownHeader() {
		driver.findElement(By.linkText("Dropdown")).click();
		String headerText = driver.findElement(By.xpath("//h3[contains(text(),'Dropdown List')]")).getText();
		Assert.assertEquals(headerText, "Dropdown List");
	
	}
	
	@Test
	public void dropDownSelection() {
		WebElement staticdropDown = driver.findElement(By.id("dropdown"));
		Select dropDown = new Select(staticdropDown);
		dropDown.selectByIndex(2);
		String selectedOptiontext = dropDown.getFirstSelectedOption().getText();
		Assert.assertEquals(selectedOptiontext, "Option 2");
	}

	@AfterTest 
	 public void endSession() { 
		 driver.quit();
	 }
}
