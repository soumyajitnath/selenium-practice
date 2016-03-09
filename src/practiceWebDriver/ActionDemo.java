package practiceWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		driver.get("http://www.iitd.ac.in/");
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//a[contains(text(),'Students Activities')]"));
		actions.moveToElement(mainMenu);
		Thread.sleep(5000L);
        //mainMenu.click();
		
		//actions.click().build().perform();
		WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(),'Entrepreneurship')]"));
		actions.moveToElement(subMenu);
		actions.click().build().perform();
		
		//subMenu.click();

	}

}
