package com.allianz.assignments;
/*Task 1 (Important) 
1.  Navigate onto http://demo.openemr.io/b/openemr/
2.  Update username as admin
3.  Update password as pass
4.  Select language as English (Indian)
5.  Click on the login button
6.  Click on Patient  Click New Search
7.  Add the first name, last name
8.  Update DOB as today's date 
driver.findElement(By.id("form_DOB")).sendKeys("2024-01-12");
9.  Update the gender
10. . Click on the create new patient button above the form
11. . Click on confirm create new patient button.
12. . Print the text from alert box (if any error before handling alert add 5 sec wait)
13. . Handle alert
14. Close the Happy Birthday popup
15. Get the added patient name and print in the console.  */
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Demo_Mar21 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://demo.openemr.io/b/openemr/");
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		Select language = new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
		language.selectByValue("18");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		WebElement mainMenu= driver.findElement(By.xpath("//div[text()='Patient']"));
		Actions actions=new Actions(driver);
		actions.moveToElement(mainMenu).perform();
		WebElement subMenu= driver.findElement(By.xpath("//div[text()='New/Search']"));
		subMenu.click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pat']")));
		driver.findElement(By.name("form_fname")).sendKeys("ABCD");
		driver.findElement(By.name("form_lname")).sendKeys("XYZ");
		driver.findElement(By.name("form_DOB")).sendKeys("2024-03-26");
		Select gender=new Select(driver.findElement(By.name("form_sex")));
		gender.selectByValue("Male");
		driver.findElement(By.xpath("//button[@id='create']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='modalframe']")));
		driver.findElement(By.xpath("//button[text()='Confirm Create New Patient']")).click();
		driver.switchTo().defaultContent();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		String actualAlertText= driver.switchTo().alert().getText();
		System.out.println("Alert Message is- '"+actualAlertText);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
		WebElement name= driver.findElement(By.xpath("//span[@data-bind='text: pname()']"));
		String displayName=name.getText();
		System.out.println("\nCreated Patient name is "+displayName);
	}
}
