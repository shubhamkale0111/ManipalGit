package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class HelperClass {

	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public static String remote_url = " http://192.168.43.253:4444/ui";
	public Capabilities capabilities;

	@Parameters({ "browser" })
	@BeforeMethod
	public void setDriver(String browser) throws MalformedURLException {

		System.out.println("Test is running on " + browser);

		if (browser.equals("chrome")) {
			//capabilities = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\DELL\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
		} else if (browser.equals("edge")) {
			//capabilities = new EdgeOptions();
			System.setProperty("webdriver.edge.driver", 
					"\"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\"");
					
					WebDriver driver = new EdgeDriver();
			
		}

		driver.set(new RemoteWebDriver(new URL(remote_url), capabilities));
		driver.get().get("https://opensource-demo.orangehrmlive.com/");
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='username']")));
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.get().quit();
		driver.remove();
	}

}
