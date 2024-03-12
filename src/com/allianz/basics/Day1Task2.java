package com.allianz.basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Day1Task2 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.citibank.co.in/ssjsps/forgetuseridmidssi.jsp");
		WebElement productType=  driver.findElement(By.linkText("select your product type"));
		productType.click();
		driver.findElement(By.linkText("Credit Card")).click();
		driver.findElement(By.id("citiCard1")).sendKeys("4545");
		driver.findElement(By.id("citiCard2")).sendKeys("5656");
		driver.findElement(By.id("citiCard3")).sendKeys("8887");
		driver.findElement(By.id("citiCard4")).sendKeys("9998");
		driver.findElement(By.id("cvvnumber")).sendKeys("100");
		driver.findElement(By.id("bill-date-long")).sendKeys("100");
		Select year= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		year.selectByValue("2022");
		Select month= new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		month.selectByValue("3");
		driver.findElement(By.linkText("14")).click();
		driver.findElement(By.xpath("//input[@value='PROCEED']")).click();
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println("Alert message is "+alertText);
		
	}

}
