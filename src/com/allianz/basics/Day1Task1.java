package com.allianz.basics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Day1Task1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/");		
		driver.findElement(By.name("UserFirstName")).sendKeys("John");
		driver.findElement(By.name("UserLastName")).sendKeys("wick");
		driver.findElement(By.name("UserEmail")).sendKeys("john@gmail.com");
		Select jobTitle= new Select(driver.findElement(By.name("UserTitle")));
		jobTitle.selectByValue("IT_Manager_AP");
		Select employeeCount= new Select(driver.findElement(By.name("CompanyEmployees")));
		employeeCount.selectByVisibleText("201 - 500 employees");
		driver.findElement(By.xpath("(//div[@class='checkbox-ui' and @data-input-check=''])[2]")).click();
		Select country= new Select(driver.findElement(By.name("CompanyCountry")));
		country.selectByVisibleText("United Kingdom");
		driver.findElement(By.name("CompanyName")).sendKeys("Allianz");
		
		driver.findElement(By.xpath("//button[@name='start my free trial' ]")).click();
		String phoneError= driver.findElement(By.xpath("//span[text()='Enter a valid phone number']")).getText();
		System.out.println("Error message is - "+phoneError);
		

}
}