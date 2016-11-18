package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/*Task 2: Verify duplicate links
Step 1: Goto facebook landing page
Step 2: Get all of the links
Step 3: Verify if the list contains duplicates,
		if it contains duplicate then print to console "You have duplicate values", 
		specify the duplicate values.*/
public class Task2 {

	private WebDriver driver = null;

	@BeforeClass
	public void beforeClass() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C://Selenium//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("http://facebook.com");
		Thread.sleep(100);

	}

	@AfterClass
	public void afterclass() {
		driver.quit();
	}

	@Test
	public void findElementByList() throws InterruptedException {
		List<WebElement> listOfElement = driver.findElements(By.tagName("a"));
		
	
		System.out.println("Number of links:" +listOfElement.size());
	
		for (int i = 0; i <= listOfElement.size(); i++) {
			
				{
						System.out.println("You have duplicate values" +listOfElement.get(i).getText());
					
				}
			
		}
	}
}