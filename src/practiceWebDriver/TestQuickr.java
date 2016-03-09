package practiceWebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestQuickr {
	
	private static final String URL = "http://www.quikr.com/";
	
	public static String now(String dateFormat) {
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	    return sdf.format(cal.getTime());

	}
	
	public void executeTestCase() throws InterruptedException{
		
		System.out.println(System.getProperty("user.dir"));
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		Thread.sleep(5000L);
		
		driver.findElement(By.id("csclose")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("selectCity")).click();
		
		if(driver.findElement(By.xpath("//*[@id='popularCitiesBox']/div[1]")).getText().equals("Popular Cities")){
			System.out.println("Select your City !");
			List<WebElement> elementList = driver.findElements(By.className("main_city_list_box"));
			for(WebElement e : elementList){
				System.out.println("" + e.getText());
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = TestQuickr.now("dd.MMMMM.yyyy hh.mm.ss aaa");
		System.out.println(str);
		
		TestQuickr testObject = new TestQuickr();
		/*try {
			
			testObject.executeTestCase();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

	}

}
