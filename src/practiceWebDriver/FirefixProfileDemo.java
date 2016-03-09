package practiceWebDriver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefixProfileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("E:\\Required Softwares to config Selenium\\firebug-1.10.3\\firebug-1.10.3.xpi");
		   FirefoxProfile firefoxProfile = new FirefoxProfile();
		   firefoxProfile.addExtension(file);
		   firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.8.1"); // Avoid startup screen

		   //
		   //System.getProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		   System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\soumyajitn\\Downloads\\chromedriver_win32\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   
		   driver.get("http://www.google.co.in");

	}

}
