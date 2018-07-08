package beginner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTag {

	static WebDriver driver;
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "D:\\Tools\\Selenium\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe") ;
		driver = new ChromeDriver();
		
		driver.get("http://www.facebook.com");
		
		Select select = new Select(driver.findElement(By.id("day")));
		select.selectByVisibleText("31");
		
		

	}

}
