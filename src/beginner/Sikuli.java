package beginner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikuli {

	static WebDriver driver;
	public static void main(String[] args) throws FindFailed {
				
		System.setProperty("webdriver.chrome.driver", "D:\\Tools\\Selenium\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe") ;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		
		Screen s = new Screen();
		Pattern p = new Pattern("D:\\sikuli images\\Sign-in.PNG");
		
		s.wait(p,10);
		s.click(p);
		
		
	}

}
