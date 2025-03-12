package Different_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bchattopadhy\\eclipse-workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://jqueryui.com/droppable/");
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.id("draggable")))
		.moveToElement(driver.findElement(By.id("droppable")))
		.release().build().perform();
		
//		driver.get("https://www.flipkart.com/");
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("SAMSUNG GALAXY S10");
//		driver.findElement(By.xpath("//input[@type='text']")).submit();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		
//		driver.findElement(By.xpath("//div[text()='SAMSUNG']//preceding-sibling::div[@class='_24_Dny']")).click();
//		
//		Thread.sleep(3000);
//		WebElement element = driver.findElement(By.cssSelector("._24_Dny._3tCU7L"));
//		element.click();
//		
//		Thread.sleep(3000);
		
		
		driver.quit();
	}

}
