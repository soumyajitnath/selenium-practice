package practiceWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LearnXpathIEDriver {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//webdriver.ie.driver = The location of the IE driver binary.
		
		//System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer_x64_2.52.1\\IEDriverServer.exe");
		//driver = new InternetExplorerDriver();
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		/*If you run the above Code only the IEDriver Server will start and
		webdriver server will display page with url :http://localhost:11873/
		"This is the initial start page for the WebDriver server."
		The below page gets displayed
		<html><head><title>WebDriver</title></head>
		<body><p id='main'>
		This is the initial start page for the WebDriver server.</p>
		</body>
		</html>
		

		The below lines will be displayed on console 
		Started InternetExplorerDriver server (64-bit)
        2.52.1.0
        Listening on port 11873
        Only local connections are allowed*/
		
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		
		//driver.findElement(By.cssSelector(".inputtext")).sendKeys("xxxxxxxxx");
		
		if(!driver.findElement(By.cssSelector("input#email")).isDisplayed()){
			System.out.println("Email input-box not present");
		}
		
		/*Locating by CSS Selector - tag and class

        css=tag.class*/
		
		driver.findElement(By.cssSelector("input.inputtext")).sendKeys("xxxxxxxxx");
		
		driver.findElement(By.cssSelector("input[class=inputtext]")).clear();
		
		driver.findElement(By.cssSelector("input[class=inputtext]")).sendKeys("yyyy");
		
		/*Locating by CSS Selector - tag and id

        css=tag#idvalue    { <input id="idvalue" /> } */
		
		driver.findElement(By.cssSelector("input#email")).click();
		
		driver.findElement(By.cssSelector("input#email")).clear();
		
		driver.findElement(By.cssSelector("input#email")).sendKeys("986144@gmail.com");
		
		/*Locating by CSS Selector - tag, class, and attribute

          css=tag.class[attribute=value]
          
          css=tag.class[attributename=attributevalue]*/
		
		driver.findElement(By.cssSelector("input.inputtext[tabindex='1']")).clear();
		
		driver.findElement(By.cssSelector("input.inputtext[tabindex='2']")).click();

		driver.findElement(By.cssSelector("input.inputtext[tabindex='2']")).sendKeys("123456789");
		
		driver.findElement(By.cssSelector("input.inputtext[tabindex='2']")).clear();
		
		//****************************Xpath**************************************************/
		
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("eeeeee");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("richard@gmail.com");
		
		driver.findElement(By.xpath("//input[@id='pass']")).clear();
		
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("qqqqqqqqqqqqqqqqqqqq");
		

        //identifying the links/static text using contains&text() function 
        //tagname[contains(text(),'partial/completetext')]
		
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Create an account')]")).getText().trim());
		
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'free')]")).getText().trim());
		
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'agree')]")).getText().trim());
		
		System.out.println(driver.findElement(By.xpath("//a[starts-with(text(),'Why do I need')]")).getText().trim());
		
		System.out.println(driver.findElement(By.xpath("//div[starts-with(text(),'Facebook')]")).getText().trim());
		
		////tagname[starts-with(@href,'hrefvalue')]
		System.out.println(driver.findElement(By.xpath("//a[starts-with(@href,'/pages/create/?ref_type=registration_form')]")).getText().trim());
		//System.out.println(driver.findElement(By.xpath("//a[contains(@href,'/recover/initiate?lwv=111')]")).getText().trim());
		
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'password')]")).getText().trim());
		
		System.out.println(driver.findElement(By.xpath("//label[contains(text(),'logged in')]")).getText().trim());
		//driver.findElement(By.cssSelector("input#email")).clear();
		
		//driver.findElement(By.cssSelector("input.inputtext")).sendKeys("xxxxxxxxx");
		
		//<input id="u_0_m" type="submit" tabindex="4" value="Log In">
		
		//Css selector = #u_0_m
		//driver.findElement(By.cssSelector("#u_0_m")).click();

	}

}
