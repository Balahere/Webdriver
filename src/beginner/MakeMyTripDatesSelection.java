package beginner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTripDatesSelection {
	static WebDriver driver;

	public static void main(String[] args) throws TimeoutException {
		System.setProperty("webdriver.chrome.driver", "D:\\Tools\\Selenium\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe") ;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		/*driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);*/
		driver.get("http://www.makemytrip.com");
		driver.findElement(By.id("hp-widget__depart")).click();
		/*String year = driver.findElement(By.xpath("//div[@style='display: block;' and @class='dateFilter hasDatepicker' ]//a[@title='Prev']//following-sibling::div[@class='ui-datepicker-title']//span[@class='ui-datepicker-year']")).getText();
		String month = driver.findElement(By.xpath("//div[@style='display: block;' and @class='dateFilter hasDatepicker' ]//a[@title='Prev']//following-sibling::div[@class='ui-datepicker-title']//span[@class='ui-datepicker-month']")).getText();
		System.out.println(year);
		System.out.println(month);*/
		String req_date="10-march-2019";
		//String altered_date= null;
		if (req_date.contains("-"))
		{
			req_date = req_date.replace('-', '/');
		}
		System.out.println(req_date);
		
		/*Date d = new Date(req_date);
		SimpleDateFormat format_date = new SimpleDateFormat("dd/mm/yyyy");
		String final_date = format_date.format(d);
		System.out.println(final_date);*/
		String[] split = req_date.split("/");
		//boolean d = true;
		
		while(true)
		{
			String year = driver.findElement(By.xpath("//div[@style='display: block;' and @class='dateFilter hasDatepicker' ]//a[@title='Prev']//following-sibling::div[@class='ui-datepicker-title']//span[@class='ui-datepicker-year']")).getText();
			if (year.equals(split[2]))
			{
				break;
					
			}
			else 
				driver.findElement(By.xpath("//div[@style='display: block;' and @class='dateFilter hasDatepicker' ]//a[@title='Next']")).click();
		}
		
		while(true)
		{
			String month = driver.findElement(By.xpath("//div[@style='display: block;' and @class='dateFilter hasDatepicker' ]//a[@title='Prev']//following-sibling::div[@class='ui-datepicker-title']//span[@class='ui-datepicker-month']")).getText();
			if (month.equalsIgnoreCase(split[1]))
			{
				break;
					
			}
			else 
				driver.findElement(By.xpath("//div[@style='display: block;' and @class='dateFilter hasDatepicker' ]//a[@title='Next']")).click();
		}
		
		
		 List<WebElement> list = driver.findElements(By.xpath("//*[@id='dp1530371014695']/div/div[1]/table/tbody//td"));
		 int count = list.size();
		 System.out.println(count);
		 
		/* for (int i=0; i<count ; i++)
		 {
			 System.out.println(list.get(i).getText());
			 String date = list.get(i).getText();
			 if (date.equals(split[0]))
			 {
				 list.get(i).click();
				 break;
			 }
		 }*/
		
		
		
	}

}
