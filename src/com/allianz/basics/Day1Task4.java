package com.allianz.basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Day1Task4 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(" https://nasscom.in/");
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//li[@data_get='register-app']")).click();
		driver.findElement(By.xpath("//input[@name='field_fname_reg[0][value]']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='field_lname[0][value]']")).sendKeys("pass");
		driver.findElement(By.id("edit-mail")).sendKeys("admin@gmail.com");
		driver.findElement(By.xpath("//input[@name='field_company_name_registration[0][value]']")).sendKeys("google");
		Select businesFocus=new Select(driver.findElement(By.xpath("//select[@name='field_business_focus_reg']")));
		businesFocus.selectByValue("51");
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		
	}

}
