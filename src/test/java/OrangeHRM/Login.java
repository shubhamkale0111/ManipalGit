package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Login {
	
public static WebDriver driver;
	
	@Test
	public void testlogin() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DELL\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
		Thread.sleep(500);
		
		driver.manage().window().maximize();
		
		
		String actualTitle = driver.getTitle();
		
		String expectedTitle = "OrangeHRM";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		
		
		
		String actualPassword = driver.getTitle();
		
		String expectedPassword = "OrangeHRM";
		
		Assert.assertEquals(actualPassword, expectedPassword);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		
	
		
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		
		System.out.print("Login Succesflly ");

	}

	

}



