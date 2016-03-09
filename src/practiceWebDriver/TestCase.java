package practiceWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase {
	
	private static final String URL="http://www.snapdeal.com/";
	
	public void executeTestCase() throws InterruptedException{
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		//Fetching a Page
		driver.get(URL);
		
		System.out.println("Title of the Page opened :" + driver.getTitle());
		
		// Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("shop online");
            }
        });
        
        System.out.println("Page title is: " + driver.getTitle());
		
		//Close the PopUp
        
		//Locating UI Elements (WebElements)
		driver.findElement(By.xpath("//*[@id='pincodeSalienceComponent']/div[2]/i")).click();
		
		//Display the Menus present on Left Hand side of webpage
		List<WebElement> elementss = driver.findElements(By.xpath("//div[@id='leftNavMenuRevamp']"));
		for(WebElement e : elementss){
			System.out.println("" + e.getText());
			
		}
		
		System.out.println("");
		
		//Display all Electronic Items 
		WebElement element = driver.findElement(By.xpath("//div[@id='leftNavMenuRevamp']//ul/li[7]/a"));
		element.click();
		
        List<WebElement> elements = driver.findElements(By.className("colDataInnerBlk"));
		
		for(WebElement e : elements){
			System.out.println("" + e.getText());
		}
		
		/*
		if(driver.getPageSource().contains("Men's Fashion")){
			driver.findElement(By.xpath("//*[@id='leftNavMenuRevamp']/div/div/ul/li[11]/a/span[3]")).click();	
		}
		else{
			Thread.sleep(2000);
		}
		
		//Locating UI Elements - By Class Name
		//<div class="cheese"><span>Cheddar</span></div>
		//<div class="cheese"><span>Gouda</span></div>
        //List<WebElement> cheeses = driver.findElements(By.className("cheese"));

		List<WebElement> elements = driver.findElements(By.className("colDataInnerBlk"));
		
		for(WebElement e : elements){
			System.out.println("" + e.getText());
		}
		
		Thread.sleep(5000L);
		
		driver.findElement(By.xpath("//*[@id='leftNavMenuRevamp']/div/div/ul/li[11]/div/div[1]/div/div/p[7]/a/span")).click();
		
		
		if(driver.getTitle().equals("Floaters for Men: Buy Mens Floaters for Best Prices in India | Snapdeal")){
			System.out.println("You are on Floaters page !!!");
			//driver.findElement(By.xpath("//*[@id='content_wrapper']/div[2]/div[3]/div[1]/div/div[2]/div[2]/div[3]/div/div[4]/label")).click();
			driver.findElement(By.xpath("//*[@id='content_wrapper']/div[2]/div[3]/div[1]/div/div[2]/div[2]/div[3]/div/div[5]/label")).click();
			Thread.sleep(5000L);
			String str = driver.findElement(By.xpath("//*[@id='content_wrapper']/div[2]/div[2]/div[3]/span")).getText();
			
			int lastIndex = str.lastIndexOf(')');
			System.out.println(lastIndex);
			
			String number = str.substring(1, lastIndex-6);
			String brand = driver.findElement(By.xpath("//*[@id='content_wrapper']/div[2]/div[3]/div[2]/div[1]/div[3]/div[1]/div/a")).getText();
			System.out.println("Show the No of Shoes avaiable under"+ brand + number);
		}*/
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCase testObj = new TestCase();
		try {
			testObj.executeTestCase();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
