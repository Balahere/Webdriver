package beginner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	static WebDriver driver;
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "D:\\Tools\\Selenium\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe") ;
		driver = new ChromeDriver();
		
		driver.get("http://www.makemytrip.com");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("ch_funnel_more"))).perform();
		

	}

}
