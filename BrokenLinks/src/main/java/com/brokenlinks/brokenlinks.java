package com.brokenlinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenlinks {
	
	
	public static void main(String[] args) throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bchattopadhy\\eclipse-workspace\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://flipkart.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		List<String> urlLinks = new ArrayList<String>();
		
		for(WebElement e:links) {
			String url = e.getAttribute("href");
			urlLinks.add(url);
//			checkBrokenLink(url);
		}
		
		System.out.println(urlLinks.size() + " links found");
		long startTime = System.currentTimeMillis();
		urlLinks.parallelStream().forEach(e -> checkBrokenLink(e));
		long endTime = System.currentTimeMillis();
		
		System.out.println("Total Time = " +(endTime - startTime));
		driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	public static void checkBrokenLink(String linkurl) {
		
		try {
			
			URL url = new URL(linkurl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			
			if(httpUrlConnection.getResponseCode() >= 400) {
				System.out.println(linkurl + "----->" + httpUrlConnection.getResponseMessage() + " is a broken link");
		}
			else {
				System.out.println(linkurl + "----->" + httpUrlConnection.getResponseMessage());
			}
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
