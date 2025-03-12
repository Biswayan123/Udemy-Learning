package com.auto.qa.testflow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;


public class StepstoAutomate {
	
	
	WebDriver driver;
	DesiredCapabilities caps = new DesiredCapabilities();
	public static final String USERNAME = "biswayanchattopa_6tI5CX";
	public static final String AUTOMATE_KEY = "sVyqqExUQPfwcxPQn5ap";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	@SuppressWarnings("deprecation")
	@Parameters("browsername")
	@BeforeTest
	public void setup(String browsername) throws Exception {
		if(browsername.equalsIgnoreCase("Safari")) {
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "Big Sur");
			caps.setCapability("browser", "Safari");
			caps.setCapability("browser_version", "14.1");
			caps.setCapability("browserstack.local", "false");
			caps.setCapability("browserstack.selenium_version", "3.14.0");
			caps.setCapability("browserstack.console", "info");
			caps.setCapability("browserstack.networkLogs", "true");
			caps.setCapability("project", "Flipkart_Product_Search");
			caps.setCapability("build", "Build_3");
			caps.setCapability("name", "Search_Product");
			caps.setCapability("browserstack.timezone" ,"Kolkata");
		    driver = new RemoteWebDriver(new java.net.URL(URL), caps);

		} else if(browsername.equalsIgnoreCase("Chrome")) {
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "94.0");
			caps.setCapability("browserstack.local", "false");
			caps.setCapability("browserstack.selenium_version", "3.14.0");
			caps.setCapability("browserstack.console", "info");
			caps.setCapability("browserstack.networkLogs", "true");
			caps.setCapability("project", "Flipkart_Product_Search");
			caps.setCapability("build", "Build_3");
			caps.setCapability("name", "Search_Product");
			caps.setCapability("browserstack.timezone" ,"Kolkata");
			driver = new RemoteWebDriver(new java.net.URL(URL), caps);			
		} else {
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("browser", "Firefox");
			caps.setCapability("browser_version", "92.0");
			caps.setCapability("browserstack.local", "false");
			caps.setCapability("browserstack.networkLogs", "true");
			caps.setCapability("browserstack.selenium_version", "3.10.0");
			caps.setCapability("browserstack.console", "info");
			caps.setCapability("browserstack.networkLogs", "true");
			caps.setCapability("project", "Flipkart_Product_Search");
			caps.setCapability("build", "Build_3");
			caps.setCapability("name", "Search_Product");
			caps.setCapability("browserstack.timezone" ,"Kolkata");
			driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
	
	        // Set up WebDriver for Chrome
		 
//		 	DesiredCapabilities caps = new DesiredCapabilities();
//		 	
//		 	caps.setCapability("platformName", "windows");
//		 	caps.setCapability("browserName", "chrome");
//		 	caps.setCapability("browserVersion", "122");
//		 	URI uri = new URI(URL);
//		    URL url = uri.toURL();
//			WebDriver driver = new RemoteWebDriver(url, caps); 
		 	
//			WebDriver driver = new ChromeDriver(); 
		 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 	
//		 	driver.manage().window().maximize();
//			driver.manage().deleteAllCookies();
//			
//			driver.get("https://www.flipkart.com/");
		 	
		 	@Test
			public void TC_001() throws Exception {
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys("SAMSUNG GALAXY S10");
				driver.findElement(By.xpath("//input[@type='text']")).submit();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				
				driver.findElement(By.xpath("//div[text()='SAMSUNG']//preceding-sibling::div[@class='_24_Dny']")).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='SAMSUNG' and @class='_3sckoD']")));
				
				WebElement element = driver.findElement(By.cssSelector("._24_Dny._3tCU7L"));
				element.click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Plus (FAssured)' and @class='_3sckoD']")));
				
				driver.findElement(By.xpath("//div[text()='Price -- High to Low']")).click();
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Price -- High to Low']")));
				
				List<WebElement> ProductNames = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
			 
	
			    List<WebElement> DisplayPrices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	
			    List<WebElement> ProductLinks = driver.findElements(By.xpath("//a[@class='_1fQZEK']"));
		        
			    for(int i=0;i<ProductNames.size();i++) {
			    	System.out.println("Product Name: " + (i+1) + " " + ProductNames.get(i).getText());
		            System.out.println("Display Price: " + DisplayPrices.get(i).getText());
		            System.out.println("Link to Product Details Page: " + ProductLinks.get(i).getAttribute("href"));
		            System.out.println();
		    }
		 }
		 	
		 	@AfterMethod
		 	public void teardown() {
	        // Quit the WebDriver
		 		driver.quit();
		 	}

}
