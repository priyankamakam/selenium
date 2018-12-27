package testclass;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
	public String url = "http://login.salesforce.com";
	String driverPath = "C:/Users/rajesh/Downloads/chromedriver_win32/chromedriver.exe";
	public WebDriver driver;
  @Test
  public void testaccount() throws InterruptedException {

		System.out.println("Launching Chromer browser");
		//testing
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginbtn = driver.findElement(By.id("Login"));

		username.sendKeys("priyankamakam.bhupal@gmail.com");
		password.sendKeys("xxxxxx");
		loginbtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement NoThanks = driver.findElement(By.id("lexNoThanks"));
		//testing
		NoThanks.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement sendtoSalesforce = driver.findElement(By.id("lexSubmit"));
		sendtoSalesforce.click();
		driver.findElement(By.xpath("//a[@href='/001/o']")).click();
		driver.findElement(By.xpath("//input[@title='New']")).click();
		WebElement AccountName = driver.findElement(By.xpath("//input[@name='acc2']"));
		String InputAccount="Selenium Priyanka Account32";
		AccountName.sendKeys(InputAccount);
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		
		String accName= driver.findElement(By.xpath("//h2[@class='topName']")).getText();
		System.out.println("Account Name:"+ accName);
		Assert.assertEquals(accName, InputAccount);
		//driver.close();
		

	}
}
