package com.allianz.tabs;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));        
        driver.get("https://www.db4free.net");
        driver.findElement(By.partialLinkText("phpMyAdmin")).click();
        ArrayList<String> windows= new ArrayList<String>(driver.getWindowHandles()); 
        driver.switchTo().window(windows.get(1)); //to move to 2nd tab
        driver.findElement(By.id("input_username")).sendKeys("admin");
        driver.findElement(By.id("input_password")).sendKeys("admin1233");
        driver.findElement(By.id("input_go")).click();
        driver.close(); //close curretnt tab
        driver.switchTo().window(windows.get(0)); // take current tab
        System.out.println(driver.getTitle());
        driver.quit();
	}

}
