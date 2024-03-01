package OrangeHRM;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddImmigration {
	
public static WebDriver driver;
	
	@Test
	public void testlogin() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DELL\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
		Thread.sleep(500);
		
		driver.manage().window().maximize();
		// login to orangehRM
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//find MyInfo and click on it
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
		
		//find immigration and click on it
		driver.findElement(By.xpath("//a[contains(text(),'Immigration')]")).click();
		Thread.sleep(1000);
		
		//Click on add immigration
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--text']")).click();
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Adj");
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys("2023-7-10");
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]")).sendKeys("2025-7-8");
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[5]")).sendKeys("2023-5-10");
		
		WebElement ele1 = driver.findElement(By.xpath("//div[@class='oxd-select-text oxd-select-text--active']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele1).click().sendKeys(Keys.DOWN).build().perform();
		
		driver.findElement(By.xpath("//button[text()=' Save ' ]")).click();
		
		System.out.print("Details Added Successfully ");
		
		
		

	}

	

}







