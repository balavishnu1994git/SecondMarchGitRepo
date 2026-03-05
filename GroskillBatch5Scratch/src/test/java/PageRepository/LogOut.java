package PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;

public class LogOut extends BaseClass {
	
	
	 WebDriver driver;
	  
	  public LogOut(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver, this);
	  }
	  
	  
	  @FindBy(xpath="//*[text()='Manager']")
	  WebElement  Managerid;
	  
	
	  @FindBy(xpath="//*[text()='Log out']")
	  WebElement  logOut;

	
	  public void clickManager()
	  {
		
		  Managerid.click();
	  }
	 
	  
	  public boolean isUserLoggedIn() {
		  
		    return Managerid.isDisplayed();
		}
	  
	  public void clickLogout()
	  {
		
		  safeClick(logOut);
	  }
	    
}
