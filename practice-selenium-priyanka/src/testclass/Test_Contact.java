package testclass;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Contact {
	public String url = "http://login.salesforce.com";
	String driverPath = "C:/Users/rajesh/Downloads/chromedriver_win32/chromedriver.exe";
	public WebDriver driver;
  @Test
  public void testcontact() throws InterruptedException, IOException {
	  	CreateReport();
	  	//testing
		System.out.println("Launching Chromer browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginbtn = driver.findElement(By.id("Login"));

		username.sendKeys("priyankamakam.bhupal@gmail.com");
		password.sendKeys("xxx");
		loginbtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement NoThanks = driver.findElement(By.id("lexNoThanks"));
		NoThanks.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement sendtoSalesforce = driver.findElement(By.id("lexSubmit"));
		sendtoSalesforce.click();
		driver.findElement(By.xpath("//a[@href='/003/o']")).click();
		driver.findElement(By.xpath("//input[@title='New']")).click();
		WebElement ContactName = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		String InputAccount="Selenium Priyanka ";
		String InputContact="Makam";
		ContactName.sendKeys(InputContact);
		Thread.sleep(1000);
		/*driver.findElement(By.xpath("//input[@title='Account Name Lookup (New Window)']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("Selenium Priyanka Account32");
		driver.findElement(By.xpath("//input[@title='Go!']")).click();*/
		WebElement AccountName = driver.findElement(By.xpath("//input[@id='con4']"));
		AccountName.sendKeys(InputAccount);
		List<WebElement> autoSuggest = driver.findElements(By.xpath("//div[@class='autoCompleteRow']"));
		 System.out.println("Size of the AutoSuggets is = " + autoSuggest.size());
		 for (WebElement a : autoSuggest) {
		  System.out.println("Values are = " + a.getText());
		 }
		 autoSuggest.get(2).click();
		 
		 driver.findElement(By.xpath("//input[@title='Save']")).click();
		
		String contName= driver.findElement(By.xpath("//h2[@class='topName']")).getText();
		System.out.println("Contact Name:"+ contName);
		Assert.assertEquals(InputContact, contName); 
		driver.close();
		

	}
private void CreateReport() throws IOException {
	FileWriter fw= new FileWriter("Result.html");
	BufferedWriter bw= new BufferedWriter(fw);
	bw.write("<html>");
	bw.write("<head>");
	bw.write("<style type=\text/cc");
}
}
