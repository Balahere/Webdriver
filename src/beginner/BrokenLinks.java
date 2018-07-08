package beginner;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver","D:\\Tools\\Selenium\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com/index.html");
		//name="username"
		//name="password"
		System.out.println("hi there welcome to the login page  and the title is :" + driver.getTitle());
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("bsolium");
		driver.findElement(By.name("password")).sendKeys("krishna");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("hi there you have just logged in and the title is :" + driver.getTitle());
		driver.switchTo().frame("mainpanel");
		Thread.sleep(3000);
		List<WebElement> listLinks = driver.findElements(By.tagName("a"));
		List<WebElement> listImg = driver.findElements(By.tagName("img"));
		List<WebElement> activeLinksImages = new ArrayList<WebElement>();
		listLinks.addAll(listImg);
		
		int linksCount = listLinks.size();
		System.out.println("the total number of links :" +linksCount);
				
		for (int i=0; i<linksCount; i++)
		{
			if (listLinks.get(i).getAttribute("href") != null && (!listLinks.get(i).getAttribute("href").contains("javascript")))
			{
				activeLinksImages.add(listLinks.get(i));
			}
						
		}
		
		int activeCount=activeLinksImages.size();
		System.out.println("the total number of active links :" +activeCount);
		
		
		for (int j=0; j<activeCount;j++)
		{
			
			HttpURLConnection connection =(HttpURLConnection) new URL(activeLinksImages.get(j).getAttribute("href")).openConnection();
			
			
			try{
			connection.connect();
			String response = connection.getResponseMessage();
			System.out.println("Link "+activeLinksImages.get(j).getAttribute("href")+"======>>"+ response );
			}
			catch(Exception e){
				
				System.out.println("exception is thrown in "+activeLinksImages.get(j).getAttribute("href"));
			}
			connection.disconnect();
			
		}
 		
		
	}

}
