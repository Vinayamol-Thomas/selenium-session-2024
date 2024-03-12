package com.allianz.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo2FB {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String actualTitle=driver.getTitle();
		System.out.println("Title is "+actualTitle);
		String currentUrl=driver.getCurrentUrl();
		System.out.println("Current URL is "+currentUrl);
		System.out.println("Page Source: "+driver.getPageSource());
		driver.quit();

	}

}
