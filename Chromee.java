package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Chromee {
	/*Task 1: Verify invalid login
	Step 1: Enter invalid username
	Step 2: Enter invalid password
	Step 3: Click on Login button
	Step 4: Verify the error message
	(Note: Expected Result: "The email or phone number you've entered doesn't match any account. Sign up for an account.")
*/
	private WebDriver driver = null;

	@BeforeClass
	public void beforeClass() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.facebook.com");

	}

	@Test
	public void enterdetails() {
		driver.findElement(By.name("email")).sendKeys("arun@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("123456");
		driver.findElement(By.id("loginbutton")).click();
	}

	@Test
	public void compare() {
		String actualtext = driver.findElement(By.xpath(".//*[@id='login_form']/div[1]")).getText();
		String comparetext = ("The email or phone number you’ve entered doesn’t match any account. Sign up for an account.");
		Assert.assertEquals(actualtext, comparetext);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
