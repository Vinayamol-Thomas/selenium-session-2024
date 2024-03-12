package com.allianz.basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
;
public class Demo5FBSignUp {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Create new account")).click();
		driver.findElement(By.name("firstname")).sendKeys("jack");
		driver.findElement(By.name("lastname")).sendKeys("wick");
		driver.findElement(By.name("reg_passwd__")).sendKeys("test123");
		driver.findElement(By.xpath("//label[text()='Custom']")).click();
		Select day=new Select(driver.findElement(By.id("day")));
		day.selectByValue("14");
		Select month=new Select(driver.findElement(By.id("month")));
		month.selectByVisibleText("Apr");
		Select year=new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("1970");
		//driver.quit();
		//driver.findElement(By.xpath(null))
	}

}
