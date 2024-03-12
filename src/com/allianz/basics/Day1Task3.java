package com.allianz.basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Day1Task3 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.medibuddy.in");
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//div[@class='coperate']")).click();
		driver.findElement(By.linkText("Learn More")).click();
		driver.findElement(By.linkText("skip")).click();
		driver.findElement(By.linkText("Login using Username & Password")).click();
		driver.findElement(By.id("username")).sendKeys("john");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.id("password")).sendKeys("john123");
		driver.findElement(By.xpath("//img[@ng-if='!showPassword']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String error= driver.findElement(By.xpath("//div[@ng-if='isPasswordWrong']")).getText();
		System.out.println("Error Message: "+error);
		
	}

}
