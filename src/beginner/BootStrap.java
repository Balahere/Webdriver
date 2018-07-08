package beginner;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrap {

	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Tools\\Selenium\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe") ;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.makemytrip.com");
		
		List<WebElement> list =driver.findElements(By.xpath("//ul[contains(@class,'ch__sub')]/li/a"));
		
		String selection = "HOLIDAYS";
		
		
		for ( int i=0; i<list.size();i++)
		{
			 //System.out.println(list.get(i).getText());
			
			if (selection.equals(list.get(i).getText()))
			{
				list.get(i).click();
				break;
			}
			
		}
		
		
		 
		
		
		

	}

}
