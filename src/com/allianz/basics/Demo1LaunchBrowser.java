package com.allianz.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Demo1LaunchBrowser {

	public static void main(String[] args) {
		WebDriver driver=null;
		String browser="ch";
		if(browser.equalsIgnoreCase("CH"))
		{
			driver= new ChromeDriver();
		}
		else
		{
		driver= new EdgeDriver();
		}
		driver.get("https://www.facebook.com/");
		String actualTitle=driver.getTitle();
		System.out.println("Title is "+actualTitle);
		String currentUrl=driver.getCurrentUrl();
		System.out.println("Current URL is "+currentUrl);
		System.out.println("Page Source: "+driver.getPageSource());
		
		driver.close();
		driver.quit();
	}

}
