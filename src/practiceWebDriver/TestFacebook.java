package practiceWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFacebook {
	
	private static final String URL = "https://www.facebook.com/";
	
	public static void executeTestCase(){
		
		//Interface referenceVariable = new implementing Class();
		WebDriver driver = new FirefoxDriver();
		
		
		
		
		//Open Url
		//referenceVariable.methodName();
		driver.get(URL);
		
		//fetch the page title
		String strTitle = driver.getTitle();
		
		//Print the Page Title
		System.out.println("Title is "+strTitle);
		
		//fetch the absolute Url
		String strAbsUrl = driver.getCurrentUrl();
		
		System.out.println("Absolute Url is "+strAbsUrl);
		
		//fetch the Page Source
		String strPageSrc = driver.getPageSource();
		System.out.println("Page Source :" + strPageSrc);
		
		//get the window Id
		String windowId = driver.getWindowHandle();
		System.out.println("" + "Window Handle : " + windowId);
		
		//close the browser
		//driver.close();
		
		//quit the WebDriver
		//driver.quit();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestFacebook.executeTestCase();

	}

}
