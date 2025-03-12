package Different_Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Download {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bchattopadhy\\eclipse-workspace\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://data.bls.gov/timeseries/CEU3133641108?data_tool=Xgtable");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='download_xlsx0']")));
		driver.findElement(By.xpath("//input[@id='download_xlsx0']")).click();
		Thread.sleep(5000);
		driver.quit();

		//System.out.println("User certificates are not present in correct path : Settings -> Security -> Credential Storage -> Trusted Certificates -> User Certificate");
	}
}
