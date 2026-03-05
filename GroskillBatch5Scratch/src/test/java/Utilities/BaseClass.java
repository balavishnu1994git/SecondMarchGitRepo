package Utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	static String browserName;
	public static WebDriver driver;
	public static WebDriver initializeDriver() 
	{
		try {
			browserName=FetchDataFromProperty.getDataFromProperty().getProperty("browserName");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//class.method.
		
		//calling fetchDataFromProperty method-> 
		//[inside that ] calling -> Constant (PROP_FILE_PATH)  
		//that call Global-> browser
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			try {
				driver.get(FetchDataFromExcel.getURL(1, 0));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().window().maximize();
		}
		
		
		if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			try {
				driver.get(FetchDataFromExcel.getURL(1, 0));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().window().maximize();
		}
		return driver;
		
		
		
	}
	
	public static String getTitle()  // call it in any page repository to get  title
	{
		String title=driver.getTitle();
		return title;
	}
	
	public static void scrollPage()   
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	public static String getCurrentURL() // call it in any page repository to get current url
	{
		String CURL=driver.getCurrentUrl();
		return CURL;
	}
	
	public  void safeClick(WebElement element) 
	{                                           // used for wait until the vesiblity =true->
		                                        // safeClick(element); use like this
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));

	    ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].scrollIntoView(true);", element);
	    ((JavascriptExecutor) driver)
	        .executeScript("arguments[0].click();", element);
	}
	
	

	  

		public static String generateRandomEmail() {
			
			return "user" + System.currentTimeMillis() + "@testmail.com";
		}
	
}
