package practiceWebDriver;

import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class LongDropdowns {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new FirefoxDriver();

		driver.get("http://css-tricks.com/examples/LongDropdowns/");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		WebElement mousemv=driver.findElement(By.linkText("Really Tall Menu"));

		Actions act = new Actions(driver);  

		List<WebElement> cheesecakes = driver.
				findElements(By.xpath("/html/body/div[2]/ul/li[1]/ul/li"));
		int locy0=0;
		int locx=0; 
		int locy1=locy0;
		Robot robot=new Robot();
		System.out.println(cheesecakes.size());
		act.moveToElement(mousemv).perform();Thread.sleep(2000);//go to menu root
		locy0=mousemv.getLocation().y+(cheesecakes.get(0).getLocation().y)/2;
		locx=mousemv.getLocation().x+(cheesecakes.get(0).getLocation().x)/4;

		for (int i=0; i<cheesecakes.size(); i++) {      
			if (cheesecakes.get(i).isDisplayed()){
				System.out.println(i+1+ ". " + cheesecakes.get(i).getText());
				locy1=cheesecakes.get(i).getLocation().y+(mousemv.getLocation().y)/2;
			}else{
				while(!cheesecakes.get(i).isDisplayed()&& locy0<locy1){
					locy0++;                
					robot.mouseMove(locx,locy0);        
				}
				System.out.println(i+1+ ". " + cheesecakes.get(i).getText());
			}
		}       
		driver.close();
	}

}
