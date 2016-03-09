package practiceWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase3 {
	
	public static String Url = "https://twitter.com/login";
	
	public static void login(){
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(Url);
		
		WebElement emailElement = driver.findElement(By.xpath("//input[@name='session[username_or_email]']"));
		
		emailElement.sendKeys("soumyajit443@gmail.com");
		
		WebElement pwdElement = driver.findElement(By.xpath("//input[@name='session[password]']"));
		
		pwdElement.sendKeys("rinku_09");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestCase3.login();
		
		
		
		

	}

}
