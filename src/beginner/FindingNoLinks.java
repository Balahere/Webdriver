package beginner;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingNoLinks {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
	
		System.setProperty("webdriver.chrome.driver","D:\\Tools\\Selenium\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe") ;
		driver=new ChromeDriver();
		driver.get("http://flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'VIEW ALL')]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@data-tracking-id='Deals of the Day']//a"));
	   List<WebElement> active = new ArrayList();
		for (int i=0 ; i<list.size();i++){
			if (list.get(i).getAttribute("href")!=null){
				active.add(list.get(i));
			}
		}
		System.out.println(active.size());
		
		for(int j=0;j<active.size();j++)
		{
			
		HttpURLConnection connection= (HttpURLConnection) new URL(active.get(j).getAttribute("href")).openConnection();
		 
		connection.connect();
		String response = connection.getResponseMessage();
		connection.disconnect();
		System.out.println(response);
		}
			

	}

}
