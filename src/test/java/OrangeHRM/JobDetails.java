package OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JobDetails{
	
public static WebDriver driver;
	
	@Test
	public void EditJobDetails() throws InterruptedException {
		
		
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
		
		driver.findElement(By.xpath("//a[contains(text(),'Job')]")).click();
		
		WebElement Edit = driver.findElement(By.xpath("//div[contains(text(),'HR Manager')]"));
		Edit.click();
		System.out.print("Not able to edit");
	

	}
}
